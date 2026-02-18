package com.bebidas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "bebida_id")
    private Bebida bebida;

    private Integer quantidade;

    private Double total;

    public Pedido() {
    }

    public Pedido(Cliente cliente, Bebida bebida, Integer quantidade, Double total) {
        this.cliente = cliente;
        this.bebida = bebida;
        this.quantidade = quantidade;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getTotal() {
        return total;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
