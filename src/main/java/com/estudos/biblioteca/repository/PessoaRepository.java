package com.estudos.biblioteca.repository;

import com.estudos.biblioteca.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
