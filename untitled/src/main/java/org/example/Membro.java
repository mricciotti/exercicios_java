package org.example;

// Classe Membro
class Membro {
    private String nome;
    private int id;
    private String email;

    public Membro(String nome, int id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Membro{" + "nome='" + nome + '\'' + ", id=" + id + ", email='" + email + '\'' + '}';
    }
}