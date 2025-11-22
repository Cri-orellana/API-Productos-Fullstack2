package com.example.tcg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tcg.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}


