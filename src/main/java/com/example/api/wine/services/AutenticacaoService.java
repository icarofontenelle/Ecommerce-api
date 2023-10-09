package com.example.api.wine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.api.wine.repositories.AcessoRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
    // Essa classe é chamada pelo Spring no momento da autenticação;
    
    @Autowired
    private AcessoRepository acessoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return acessoRepository.findByLogin(username);
    }

}
