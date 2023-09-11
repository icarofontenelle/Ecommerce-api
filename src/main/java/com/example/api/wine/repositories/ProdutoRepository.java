package com.example.api.wine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.wine.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
