package com.estudos.biblioteca.model;

import jakarta.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <- garante auto-increment
    private Long id;

    private String titulo;
    private String autor;
    private int totPaginas;
    private boolean emprestado = false; // valor padrão

    public Livro() {}

    public Livro(String titulo, String autor, int totPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.totPaginas = totPaginas;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getTotPaginas() { return totPaginas; }
    public void setTotPaginas(int totPaginas) { this.totPaginas = totPaginas; }

    public boolean isEmprestado() { return emprestado; }
    public void setEmprestado(boolean emprestado) { this.emprestado = emprestado; }
}
