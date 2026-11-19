package com.telovendo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telovendo.backend.model.Producto;



@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
        // Conecta directamente con la base de datos
}
