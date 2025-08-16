package com.estudos.biblioteca.service;

import com.estudos.biblioteca.model.Livro;
import com.estudos.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro salvar(Livro livro){
        return livroRepository.save(livro);
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Livro emprestar(Long id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        if (livro.isEmprestado()) {
            throw new RuntimeException("Livro já está emprestado");
        }
        livro.setEmprestado(true);
        return livroRepository.save(livro); //
    }


}
