package com.example.api.wine.Infra.exceptions;

public class ValidacaoException extends RuntimeException {

    public ValidacaoException(String mensagem) {
        super(mensagem);
    }

}
