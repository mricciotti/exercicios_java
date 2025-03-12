package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

class Emprestimo {
    private Livro livro;
    private Membro membro;
    private Date dataEmprestimo;

    public Emprestimo(Livro livro, Membro membro) {
        this.livro = livro;
        this.membro = membro;
        this.dataEmprestimo = new Date();
        livro.setEmprestado(true);
    }

    public Livro getLivro() { return livro; }
    public Membro getMembro() { return membro; }
    public Date getDataEmprestimo() { return dataEmprestimo; }

    @Override
    public String toString() {
        return "Emprestimo{" + "livro=" + livro.getTitulo() + ", membro=" + membro.getNome() + ", dataEmprestimo=" + dataEmprestimo + '}';
    }
}
