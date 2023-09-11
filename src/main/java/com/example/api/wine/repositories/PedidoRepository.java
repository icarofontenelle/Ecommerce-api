package com.example.api.wine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.wine.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
