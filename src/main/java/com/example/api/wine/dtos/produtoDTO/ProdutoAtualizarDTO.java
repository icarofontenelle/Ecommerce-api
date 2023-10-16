package com.example.api.wine.dtos.produtoDTO;

import jakarta.validation.constraints.NotNull;

public record ProdutoAtualizarDTO(
    @NotNull
    Long id,

    String nome,
    Double preco, 
    String descricao, 
    String imagem, 
    Integer qtd_estoque) {

}
