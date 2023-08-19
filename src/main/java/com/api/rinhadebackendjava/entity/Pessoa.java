package com.api.rinhadebackendjava.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pessoas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Pessoa {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  @Column(nullable = false, unique = true, length = 32)
  private String apelido;
  @Column(nullable = false, length = 100)
  private String nome;
  @Column(nullable = false)
  private String nascimento;
  @Convert(converter = StringConverter.class)
  private List<String> stack;
}
