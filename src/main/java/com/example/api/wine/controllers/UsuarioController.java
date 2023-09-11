package com.example.api.wine.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.wine.dtos.UsuarioAtualizarDTO;
import com.example.api.wine.dtos.UsuarioCadastroDTO;
import com.example.api.wine.dtos.UsuarioListagemDTO;
import com.example.api.wine.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public void registrarUsuario(@RequestBody @Valid UsuarioCadastroDTO dados_usuario){
        usuarioService.criarUsuario(dados_usuario);
    } 
    
    @GetMapping
    public Page<UsuarioListagemDTO> listarUsuarios(){
        return usuarioService.listarUsuarios(null);
    }

    @PutMapping
    public void atualizarUsuario(@RequestBody @Valid UsuarioAtualizarDTO dados_usuario){
        usuarioService.atualizarUsuario(dados_usuario);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        usuarioService.excluirUsuario(id);
    }

}
