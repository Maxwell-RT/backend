package com.Gato.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gato.backend.model.Orden;
import com.Gato.backend.repository.OrdenRepository;

@Service
public class OrdenService {
    @Autowired
    private OrdenRepository ordenRepository;

    public List<Orden> obtenerOrden(){
        return ordenRepository.findAll();
        
    }
}
