package com.example.api.wine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.wine.dtos.AutenticacaoDTO;
import com.example.api.wine.dtos.TokenJwtDTO;
import com.example.api.wine.services.AutenticacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    AutenticacaoService autenticacaoService;

    @PostMapping
    public ResponseEntity<TokenJwtDTO> efetuarLogin(@RequestBody @Valid AutenticacaoDTO autenticacaoDTO) {
        String tokenJWT = autenticacaoService.autenticar(autenticacaoDTO);
        return ResponseEntity.ok(new TokenJwtDTO(tokenJWT));
    }

}
