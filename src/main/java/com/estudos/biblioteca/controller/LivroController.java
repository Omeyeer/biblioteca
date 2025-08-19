package com.estudos.biblioteca.controller;

import com.estudos.biblioteca.model.Livro;
import com.estudos.biblioteca.repository.LivroRepository;
import com.estudos.biblioteca.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> listarTodos(){
        return livroService.listarTodos();
    }

    @PostMapping
    public Livro criar(@RequestBody Livro livro){
        return livroService.salvar(livro);
    }

    @PostMapping("/{id}/emprestar")
    public ResponseEntity<String> emprestar(@PathVariable Long id){
        livroService.emprestar(id);
        return ResponseEntity.ok("Livro emprestado com sucesso!");
    }

    @PostMapping("/{id}/devolver")
    public ResponseEntity<String> devolver(@PathVariable Long id){
        livroService.devolver(id);
        return ResponseEntity.ok("Livro devolvido com sucesso!");
    }
}
