package com.example.api.wine.dtos;

import com.example.api.wine.entities.Usuario;

public record UsuarioListagemDTO (Long id, String nome, String sobrenome, String email) {

    public UsuarioListagemDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getSobrenome(), usuario.getEmail());
    }
    

}
