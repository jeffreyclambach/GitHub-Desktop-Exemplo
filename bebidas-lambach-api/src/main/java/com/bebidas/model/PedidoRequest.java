package com.bebidas.model;

public class PedidoRequest {

    private Long clienteId;
    private Long bebidaId;
    private Integer quantidade;

    public Long getClienteId() {
        return clienteId;
    }

    public Long getBebidaId() {
        return bebidaId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setBebidaId(Long bebidaId) {
        this.bebidaId = bebidaId;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
