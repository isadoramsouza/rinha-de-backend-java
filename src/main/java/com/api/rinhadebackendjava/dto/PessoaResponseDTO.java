package com.api.rinhadebackendjava.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class PessoaResponseDTO {
  private UUID id;
  private String apelido;
  private String nome;
  private String nascimento;
  private List<String> stack;
}
