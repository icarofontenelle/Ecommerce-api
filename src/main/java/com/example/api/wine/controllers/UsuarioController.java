package com.example.api.wine.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.api.wine.dtos.usuarioDTO.UsuarioAtualizarDTO;
import com.example.api.wine.dtos.usuarioDTO.UsuarioCadastroDTO;
import com.example.api.wine.dtos.usuarioDTO.UsuarioDetalhamentoDTO;
import com.example.api.wine.dtos.usuarioDTO.UsuarioListagemDTO;
import com.example.api.wine.services.UsuarioService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity <UsuarioDetalhamentoDTO> registrar(@RequestBody @Valid UsuarioCadastroDTO dados_usuario, UriComponentsBuilder uriBuilder){
        
        var usuarioCriado = usuarioService.criarUsuario(dados_usuario);
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuarioCriado.getId()).toUri();
        
        return ResponseEntity.created(uri).body(new UsuarioDetalhamentoDTO(usuarioCriado));
    } 
    
    @GetMapping
    public ResponseEntity <Page<UsuarioListagemDTO>> listar(@PageableDefault(size = 10, sort = "nome") Pageable paginacao){
        var page = usuarioService.listarUsuarios(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    public ResponseEntity <UsuarioDetalhamentoDTO> atualizar(@RequestBody @Valid UsuarioAtualizarDTO dados_usuario){
        var usuarioAtualizado = usuarioService.atualizarUsuario(dados_usuario);
        return ResponseEntity.ok(new UsuarioDetalhamentoDTO(usuarioAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> excluir(@PathVariable Long id){
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity <UsuarioDetalhamentoDTO> detalhar(@PathVariable Long id) {
        var usuario = usuarioService.detalharUsuario(id);
        return ResponseEntity.ok(new UsuarioDetalhamentoDTO(usuario));
    }

}
