package org.example;

// Classe Principal para Teste
public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Adicionando livros
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "1234567890");
        Livro livro2 = new Livro("1984", "George Orwell", "0987654321");
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);

        // Registrando membros
        Membro membro1 = new Membro("João Silva", 1, "joao@email.com");
        biblioteca.registrarMembro(membro1);

        // Realizando empréstimo
        biblioteca.emprestarLivro("1234567890", 1);

        // Tentando emprestar o mesmo livro
        biblioteca.emprestarLivro("1234567890", 1);

        // Devolvendo o livro
        biblioteca.devolverLivro("1234567890");
    }
}
