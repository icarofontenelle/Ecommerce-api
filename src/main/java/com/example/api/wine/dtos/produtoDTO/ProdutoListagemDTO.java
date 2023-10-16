package com.example.api.wine.dtos.produtoDTO;

import com.example.api.wine.entities.Produto;

public record ProdutoListagemDTO(Long id, String nome, Double preco, String descricao, String imagem) {

    public ProdutoListagemDTO(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getPreco(), produto.getDescricao(), produto.getImagem());
    }

}
