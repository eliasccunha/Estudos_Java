package LojaTech.example.Projeto2.model;

import jakarta.persistence.*;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    private int quantidade;
    private double preco;

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
}
