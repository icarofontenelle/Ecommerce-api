package com.example.api.wine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.wine.entities.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    
}
