package com.example.api.wine.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record PedidoCadastroDTO(
    Long id,
    
    @Valid
    @NotNull
    UsuarioCadastroDTO usuario,
    
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "UTC") 
    LocalDate dataPedido,

    @NotNull
    Double total) {
    
}
