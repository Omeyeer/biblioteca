package com.estudos.biblioteca.controller;
import java.util.Optional;
import com.estudos.biblioteca.model.Livro;
import org.springframework.http.ResponseEntity;
import com.estudos.biblioteca.service.LivroService;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public Livro cadastrar(@RequestBody Livro livro) {
        return livroService.salvar(livro);
    }

    @GetMapping
    public List<Livro> listar() {
        return livroService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Livro> deletar(@PathVariable Long id) {
        Optional<Livro> livroDeletado = livroService.deletarPorId(id);

        if (livroDeletado.isPresent()) {
            return ResponseEntity.ok(livroDeletado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/emprestar/{id}")
    public Livro emprestar(@PathVariable Long id) {
        return livroService.emprestar(id);
    }
}
