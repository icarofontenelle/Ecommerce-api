package com.example.api.wine.dtos;

import jakarta.validation.constraints.NotNull;

public record UsuarioAtualizarDTO(
    @NotNull
    Long id, 
    
    String nome, 
    String sobrenome, 
    EnderecoCadastroDTO endereco) {

}
