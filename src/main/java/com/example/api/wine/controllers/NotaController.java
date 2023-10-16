package com.example.api.wine.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.wine.dtos.NotaCadastroDTO;
import com.example.api.wine.dtos.NotaListagemDTO;
import com.example.api.wine.services.NotaService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("nota")
@SecurityRequirement(name = "bearer-key")
public class NotaController {
    
    @Autowired
    private NotaService notaService;

    @PostMapping
    @Transactional
    public void registrarNota(@RequestBody @Valid NotaCadastroDTO dados_nota){
        notaService.criarNota(dados_nota);
    }

    @GetMapping
    public Page<NotaListagemDTO>listarNotas(){
        return notaService.listarNotas(null);
    }
}
