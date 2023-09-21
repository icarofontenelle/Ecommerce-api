package com.example.api.wine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.api.wine.configurations.security.TokenConfig;
import com.example.api.wine.dtos.AutenticacaoDTO;
import com.example.api.wine.entities.Acesso;
import com.example.api.wine.repositories.AcessoRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private AcessoRepository acessoRepository;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenConfig tokenConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        return acessoRepository.findByLogin(username);
    }

    public String autenticar(AutenticacaoDTO autenticacaoDTO) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(autenticacaoDTO.login(), autenticacaoDTO.senha());
        var authentication = manager.authenticate(authenticationToken);

        return tokenConfig.gerarToken((Acesso) authentication.getPrincipal());
    }

    
}
