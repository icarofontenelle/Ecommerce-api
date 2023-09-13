package com.example.api.wine.dtos.usuarioDTO;

import com.example.api.wine.dtos.EnderecoCadastroDTO;

import jakarta.validation.constraints.NotNull;

public record UsuarioAtualizarDTO(
    @NotNull
    Long id, 
    
    String nome, 
    String sobrenome, 
    EnderecoCadastroDTO endereco) {

}
