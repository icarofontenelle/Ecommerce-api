package com.example.api.wine.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record NotaCadastroDTO(
    Long id,
    
    @Valid
    @NotNull
    PedidoCadastroDTO pedido,
    
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "UTC")
    LocalDate dataEmissao,

    @NotNull
    Double valorTotal) {
    
}
