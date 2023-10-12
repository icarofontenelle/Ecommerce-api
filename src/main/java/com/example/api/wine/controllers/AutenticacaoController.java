package com.example.api.wine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.wine.configurations.security.TokenConfig;
import com.example.api.wine.dtos.AutenticacaoDTO;
import com.example.api.wine.dtos.TokenJwtDTO;
import com.example.api.wine.entities.Acesso;
import com.example.api.wine.services.AutenticacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    AutenticacaoService autenticacaoService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenConfig tokenConfig;

    @PostMapping
    public ResponseEntity<TokenJwtDTO> efetuarLogin(@RequestBody @Valid AutenticacaoDTO autenticacaoDTO) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(autenticacaoDTO.login().trim(), autenticacaoDTO.senha().trim());
        var authentication = manager.authenticate(authenticationToken);

        String tokenJWT = tokenConfig.gerarToken((Acesso) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJwtDTO(tokenJWT));
    }

}
