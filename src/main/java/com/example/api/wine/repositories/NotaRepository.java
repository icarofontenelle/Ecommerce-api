package com.example.api.wine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.wine.entities.Nota;

public interface NotaRepository extends JpaRepository<Nota,Long>{
    
}
