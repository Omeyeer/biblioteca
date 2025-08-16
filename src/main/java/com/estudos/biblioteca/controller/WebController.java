package com.estudos.biblioteca.controller;

import com.estudos.biblioteca.model.Livro;
import com.estudos.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    private final LivroRepository livroRepository;

    public WebController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    // Página inicial
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("livros", livroRepository.findAll());
        return "index"; // index.html exibe todos os livros
    }

    // Página para adicionar novo livro
    @GetMapping("/novo")
    public String novoLivro(Model model) {
        model.addAttribute("livro", new Livro());
        return "novo";
    }

    // Recebe o formulário e salva o livro
    @PostMapping("/salvar")
    public String salvarLivro(@ModelAttribute Livro livro) {
        livroRepository.save(livro);
        return "redirect:/"; // volta para a lista de livros
    }
}
