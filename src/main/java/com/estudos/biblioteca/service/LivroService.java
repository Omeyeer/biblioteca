package com.estudos.biblioteca.service;

import com.estudos.biblioteca.model.Livro;
import com.estudos.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro salvar(Livro livro){
        return livroRepository.save(livro);
    }

    public Optional<Livro> deletarPorId(Long id) {
        Optional<Livro> livroOptional = livroRepository.findById(id);

        if (livroOptional.isPresent()) {

            livroRepository.delete(livroOptional.get());
        }
        return livroOptional;
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

    public Livro devolver(Long id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        if (!livro.isEmprestado()){
            throw new RuntimeException("O livro não está emprestado para ser devolvido!");
        }
        livro.setEmprestado(false);
        return livroRepository.save(livro);
    }


}
