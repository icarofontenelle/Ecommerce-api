package com.example.api.wine.dtos;

import com.example.api.wine.dtos.produtoDTO.ProdutoCadastroDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record ItemPedidoCadastroDTO(
    
    @Valid
    @NotNull
    PedidoCadastroDTO pedido,
    
    @Valid
    @NotNull
    ProdutoCadastroDTO produto,
    
    @NotNull
    int quantidade,
    
    @NotNull
    Double precoUnitario) {
    
}
