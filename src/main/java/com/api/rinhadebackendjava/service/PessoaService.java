package com.api.rinhadebackendjava.service;


import com.api.rinhadebackendjava.dto.PessoaRequestDTO;
import com.api.rinhadebackendjava.dto.PessoaResponseDTO;
import com.api.rinhadebackendjava.entity.Pessoa;
import com.api.rinhadebackendjava.exception.BadRequestException;
import com.api.rinhadebackendjava.exception.NotFoundException;
import com.api.rinhadebackendjava.exception.UnprocessableEntityException;
import com.api.rinhadebackendjava.repository.PessoaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PessoaService {

  private final PessoaRepository pessoaRepository;

  public PessoaService(PessoaRepository pessoaRepository) {
      this.pessoaRepository = pessoaRepository;
  }

  public PessoaResponseDTO save(PessoaRequestDTO pessoaRequest) {
    Pessoa p;
    try {
      p = pessoaRepository.save(pessoaRequest.toEntity());
    } catch (DataIntegrityViolationException e) {
      throw new UnprocessableEntityException(String.format("Unprocessable Entity: %s", e.getMessage()));
    }
    return PessoaResponseDTO.builder()
            .id(p.getId())
            .nome(p.getNome())
            .apelido(p.getApelido())
            .nascimento(p.getNascimento())
            .stack(p.getStack())
            .build();
  }

  public PessoaResponseDTO getPessoaByID(UUID id) {
    Pessoa p = pessoaRepository.findById(id).orElseThrow(
            () -> new NotFoundException(String.format("Pessoa with id %s not found", id)));
    return PessoaResponseDTO.builder()
            .id(p.getId())
            .nome(p.getNome())
            .apelido(p.getApelido())
            .nascimento(p.getNascimento())
            .stack(p.getStack())
            .build();
  }

  public List<PessoaResponseDTO> getAllBySearchTerm(String searchTerm) {
    if (searchTerm == null || searchTerm.isBlank())
      throw new BadRequestException("Search term cannot be null or blank");

    return pessoaRepository.findAllBySearchTerm(searchTerm).stream()
        .map(p -> PessoaResponseDTO.builder()
            .id(p.getId())
            .nome(p.getNome())
            .apelido(p.getApelido())
            .nascimento(p.getNascimento())
                .stack(p.getStack())
            .build())
        .toList();
  }

  public Long count() {
    return pessoaRepository.count();
  }

}
