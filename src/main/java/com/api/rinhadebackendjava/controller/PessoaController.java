package com.api.rinhadebackendjava.controller;

import com.api.rinhadebackendjava.dto.PessoaRequestDTO;
import com.api.rinhadebackendjava.dto.PessoaResponseDTO;
import com.api.rinhadebackendjava.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

  private final PessoaService pessoaService;

  public PessoaController(PessoaService pessoaService) {
      this.pessoaService = pessoaService;
  }

  @PostMapping
  public ResponseEntity<PessoaResponseDTO> save(@Valid @RequestBody PessoaRequestDTO pessoaRequest) {
    PessoaResponseDTO pessoaResponse = pessoaService.save(pessoaRequest);
    URI uri = ServletUriComponentsBuilder
        .fromPath("/pessoas/{id}")
        .buildAndExpand(pessoaResponse.getId())
        .toUri();
    return ResponseEntity.created(uri).body(pessoaResponse);
  }

  @GetMapping("/{pessoaID}")
  public ResponseEntity<PessoaResponseDTO> get(@PathVariable UUID pessoaID) {
    PessoaResponseDTO pessoaResponse = pessoaService.getPessoaByID(pessoaID);
    return ResponseEntity.ok().body(pessoaResponse);
  }

  @GetMapping
  public ResponseEntity<List<PessoaResponseDTO>> findAllBySearchTerm(@RequestParam(value = "t") String searchTerm) {
    return ResponseEntity.ok(pessoaService.getAllBySearchTerm(searchTerm));
  }

  @GetMapping("/contagem-pessoas")
  public ResponseEntity<String> countPeople() {
    return ResponseEntity.ok(pessoaService.count().toString());
  }

}
