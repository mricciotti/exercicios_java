package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Biblioteca {
    private List<Livro> livros;
    private List<Membro> membros;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.membros = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void removerLivro(String ISBN) {
        livros.removeIf(livro -> livro.getISBN().equals(ISBN));
    }

    public void registrarMembro(Membro membro) {
        membros.add(membro);
    }

    public void emprestarLivro(String ISBN, int membroId) {
        Livro livroEmprestado = null;
        for (Livro livro : livros) {
            if (livro.getISBN().equals(ISBN) && !livro.isEmprestado()) {
                livroEmprestado = livro;
                break;
            }
        }

        if (livroEmprestado == null) {
            System.out.println("Livro não disponível para empréstimo.");
            return;
        }

        Membro membro = null;
        for (Membro m : membros) {
            if (m.getId() == membroId) {
                membro = m;
                break;
            }
        }

        if (membro == null) {
            System.out.println("Membro não encontrado.");
            return;
        }

        Emprestimo emprestimo = new Emprestimo(livroEmprestado, membro);
        emprestimos.add(emprestimo);
        System.out.println("Livro emprestado com sucesso!");
    }

    public void devolverLivro(String ISBN) {
        Iterator<Emprestimo> iterator = emprestimos.iterator();
        while (iterator.hasNext()) {
            Emprestimo emprestimo = iterator.next();
            if (emprestimo.getLivro().getISBN().equals(ISBN)) {
                emprestimo.getLivro().setEmprestado(false);
                iterator.remove();
                System.out.println("Livro devolvido com sucesso!");
                return;
            }
        }
        System.out.println("Empréstimo não encontrado.");
    }
}
