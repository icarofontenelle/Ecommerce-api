package com.example.api.wine.services.validacoes.produtoValidacoes;

import org.springframework.stereotype.Component;

import com.example.api.wine.Infra.exceptions.ValidacaoException;
import com.example.api.wine.dtos.produtoDTO.ProdutoCadastroDTO;

@Component
public class ValidacaoPrecoMenorZero implements ValidadorProduto{
    
    //método para validar se o preço do produto não é negativo.
    public void validar(ProdutoCadastroDTO produtoCadastroDTO){

        var precoProduto = produtoCadastroDTO.preco();

        if(precoProduto <= 0){
            throw new ValidacaoException("Preço do produto inválido");
        }
    }
}
