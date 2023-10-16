package com.example.api.wine.dtos.produtoDTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoCadastroDTO (
    Long id,
    
    @NotBlank
    String nome,
    
    @NotNull 
    Double preco, 
    
    @NotBlank
    String descricao,
    
    
    String imagem, 
    
    @NotNull
    Integer qtd_estoque) {


}
