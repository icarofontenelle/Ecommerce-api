package com.example.api.wine.dtos;

import java.time.LocalDate;

import com.example.api.wine.entities.Nota;

public record NotaListagemDTO(Long id, String nomeCliente, LocalDate dataEmissao, Double valorTotal) {
    
    public NotaListagemDTO(Nota nota){
        this(nota.getId(), nota.getCliente(), nota.getDataEmissao(), nota.getValorTotal());
    }

}
