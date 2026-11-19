package com.telovendo.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telovendo.backend.model.Producto;
import com.telovendo.backend.repository.ProductoRepository;

@Service
public class ProductoService {
    
    private ProductoRepository productoRepository;

    ///Reglas de negocio de la aplicacion
    /// Consulta de elementos de la DB
    /// 
    
    public List<Producto> obtenertodos() {
        return productoRepository.findAll();
    }

    public Producto obtenerporId(Long id) {
        return productoRepository.findById(id).
            orElseThrow(() -> new RuntimeException("Producto no encontrado por id: " + id));
    }

    
}
