package com.api.rinhadebackendjava.dto;

import com.api.rinhadebackendjava.entity.Pessoa;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PessoaRequestDTO {

  private String uuid;
  @NotNull
  @NotEmpty
  @Length(min = 1, max = 32)
  private String apelido;
  @NotNull
  @NotEmpty
  @Length(min = 1, max = 100)
  private String nome;
  @NotNull
  @NotEmpty
  @Pattern(regexp = "^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$", message = "Date is invalid. Valid format: 'YYYY-MM-DD'")
  private String nascimento;
  private List<@Size(min = 1, max=32) String> stack;

  public Pessoa  toEntity() {
    return Pessoa.builder()
            .id(UUID.randomUUID())
            .apelido(apelido)
            .nome(nome)
            .nascimento(nascimento)
            .stack(stack)
            .build();
  }
}

