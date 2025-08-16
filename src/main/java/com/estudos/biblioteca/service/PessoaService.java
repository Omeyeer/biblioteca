package com.estudos.biblioteca.service;

import com.estudos.biblioteca.model.Pessoa;
import com.estudos.biblioteca.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarTodos(){
        return pessoaRepository.findAll();
    }
}
