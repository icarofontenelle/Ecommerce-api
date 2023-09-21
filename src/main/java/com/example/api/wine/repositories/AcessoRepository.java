package com.example.api.wine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.api.wine.entities.Acesso;

public interface AcessoRepository extends JpaRepository<Acesso, Long>{

    UserDetails findByLogin(String login);
    
}
