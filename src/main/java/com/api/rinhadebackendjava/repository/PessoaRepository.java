package com.api.rinhadebackendjava.repository;

import com.api.rinhadebackendjava.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

  @Query(
      nativeQuery = true,
      value = "SELECT id, apelido, nome, nascimento, stack from pessoas p where" +
          " p.nome LIKE  %:searchTerm%" +
          " OR p.apelido LIKE %:searchTerm%" +
          " OR p.stack LIKE %:searchTerm% LIMIT 50;"
  )
  List<Pessoa> findAllBySearchTerm(@Param("searchTerm") String searchTerm);


}