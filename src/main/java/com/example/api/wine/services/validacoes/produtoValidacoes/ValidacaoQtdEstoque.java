package com.example.api.wine.services.validacoes.produtoValidacoes;

import org.springframework.stereotype.Component;

import com.example.api.wine.Infra.exceptions.ValidacaoException;
import com.example.api.wine.dtos.produtoDTO.ProdutoCadastroDTO;

@Component
public class ValidacaoQtdEstoque implements ValidadorProduto {
    
    public void validar(ProdutoCadastroDTO produtoCadastroDTO){
        
        var qtdEstoque = produtoCadastroDTO.qtd_estoque();

        if(qtdEstoque <=0 ){
            throw new ValidacaoException("Quantidade de produto no estoque insuficiente.");
        }
    }
}
