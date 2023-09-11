package com.example.api.wine.dtos;

import java.time.LocalDate;

import com.example.api.wine.entities.Pedido;

public record PedidoListagemDTO(Long id, String nomeUsuario, LocalDate dataPedido, Double total) {
    
    public PedidoListagemDTO(Pedido pedido){
        this(pedido.getId(), pedido.getUsuario().getNome(), pedido.getDataPedido(), pedido.getTotal());
    }

}
