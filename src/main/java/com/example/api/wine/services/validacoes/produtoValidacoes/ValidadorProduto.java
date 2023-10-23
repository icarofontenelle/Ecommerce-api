package com.example.api.wine.services.validacoes.produtoValidacoes;

import com.example.api.wine.dtos.produtoDTO.ProdutoCadastroDTO;

public interface ValidadorProduto {
    
   public void validar(ProdutoCadastroDTO produtoCadastroDTO);
}
