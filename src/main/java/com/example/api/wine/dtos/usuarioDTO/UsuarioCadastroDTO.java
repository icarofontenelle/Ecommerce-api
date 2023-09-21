package com.example.api.wine.dtos.usuarioDTO;

import java.time.LocalDate;

import com.example.api.wine.dtos.EnderecoCadastroDTO;
import com.example.api.wine.entities.Role;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioCadastroDTO(
    Long id,
    
    @NotBlank
    String nome,
    
    @NotBlank
    String sobrenome,
    
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate nascimento,
    
    @NotNull
    Role role,
    
    @NotBlank
    @Email
    String email,
    
    @NotBlank
    String senha,
    
    @NotBlank
    String cpf,

    @NotNull
    @Valid
    EnderecoCadastroDTO endereco) {

    
}
