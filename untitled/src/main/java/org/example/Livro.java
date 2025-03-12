package org.example;

// Classe Livro
class Livro {
    private String titulo;
    private String autor;
    private String ISBN;
    private boolean emprestado;

    public Livro(String titulo, String autor, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.emprestado = false;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getISBN() { return ISBN; }
    public boolean isEmprestado() { return emprestado; }
    public void setEmprestado(boolean emprestado) { this.emprestado = emprestado; }

    @Override
    public String toString() {
        return "Livro{" + "titulo='" + titulo + '\'' + ", autor='" + autor + '\'' + ", ISBN='" + ISBN + '\'' + '}';
    }
}