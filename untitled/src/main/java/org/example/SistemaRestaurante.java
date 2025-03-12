package org.example;

import java.util.ArrayList;
import java.util.List;

// Classe Prato
class Prato {
    private String nome;
    private double preco;
    private String descricao;

    public Prato(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public String getDescricao() { return descricao; }

    @Override
    public String toString() {
        return nome + " - R$" + preco + " (" + descricao + ")";
    }
}

// Classe Pedido
class Pedido {
    private static int contadorPedidos = 1;
    private int numeroPedido;
    private String cliente;
    private List<Prato> listaDePratos;
    private double total;

    public Pedido(String cliente) {
        this.numeroPedido = contadorPedidos++;
        this.cliente = cliente;
        this.listaDePratos = new ArrayList<>();
        this.total = 0;
    }

    public void adicionarPrato(Prato prato) {
        listaDePratos.add(prato);
        total += prato.getPreco();
    }

    public void removerPrato(String nomePrato) {
        listaDePratos.removeIf(prato -> prato.getNome().equals(nomePrato));
        recalcularTotal();
    }

    private void recalcularTotal() {
        total = 0;
        for (Prato prato : listaDePratos) {
            total += prato.getPreco();
        }
    }

    public double getTotal() {
        return total;
    }

    public void visualizarPedido() {
        System.out.println("Pedido #" + numeroPedido + " - Cliente: " + cliente);
        for (Prato prato : listaDePratos) {
            System.out.println(prato);
        }
        System.out.println("Total: R$" + total);
    }
}

// Classe Restaurante para gerenciar cardápio e pedidos
class Restaurante {
    private List<Prato> cardapio;
    private List<Pedido> pedidos;

    public Restaurante() {
        this.cardapio = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPratoAoCardapio(Prato prato) {
        cardapio.add(prato);
    }

    public void removerPratoDoCardapio(String nomePrato) {
        cardapio.removeIf(prato -> prato.getNome().equals(nomePrato));
    }

    public void listarCardapio() {
        System.out.println("--- Cardápio ---");
        for (Prato prato : cardapio) {
            System.out.println(prato);
        }
    }

    public Pedido criarPedido(String cliente) {
        Pedido novoPedido = new Pedido(cliente);
        pedidos.add(novoPedido);
        return novoPedido;
    }
}

// Classe principal para testes
public class SistemaRestaurante {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();

        // Adicionando pratos ao cardápio
        restaurante.adicionarPratoAoCardapio(new Prato("Hamburguer", 25.50, "Pão artesanal, carne 180g, queijo cheddar"));
        restaurante.adicionarPratoAoCardapio(new Prato("Pizza Margherita", 39.90, "Molho de tomate, mussarela, manjericão"));
        restaurante.adicionarPratoAoCardapio(new Prato("Sushi", 50.00, "10 peças variadas de sushi"));

        // Listando cardápio
        restaurante.listarCardapio();

        // Criando um pedido
        Pedido pedido1 = restaurante.criarPedido("Carlos Silva");
        pedido1.adicionarPrato(new Prato("Hamburguer", 25.50, "Pão artesanal, carne 180g, queijo cheddar"));
        pedido1.adicionarPrato(new Prato("Pizza Margherita", 39.90, "Molho de tomate, mussarela, manjericão"));
        pedido1.visualizarPedido();

        // Removendo prato do pedido
        pedido1.removerPrato("Hamburguer");
        pedido1.visualizarPedido();
    }
}
