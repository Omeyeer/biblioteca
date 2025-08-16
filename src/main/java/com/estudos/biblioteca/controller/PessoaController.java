package com.estudos.biblioteca.controller;

import com.estudos.biblioteca.model.Pessoa;
import com.estudos.biblioteca.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public Pessoa cadastrar (@RequestBody Pessoa pessoa){
        return pessoaService.salvar(pessoa);
    }

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaService.listarTodos();
    }
}
