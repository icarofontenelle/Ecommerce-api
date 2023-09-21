package com.example.api.wine.dtos.usuarioDTO;

import java.time.LocalDate;


import com.example.api.wine.entities.Endereco;
import com.example.api.wine.entities.Role;
import com.example.api.wine.entities.Usuario;

public record UsuarioDetalhamentoDTO(Long id, String nome, String sobrenome, LocalDate nascimento, Role role, String email, Endereco endereco) {

    public UsuarioDetalhamentoDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getSobrenome(), usuario.getNascimento(), usuario.getRole(), usuario.getEmail(), usuario.getEndereco());
    }
}
