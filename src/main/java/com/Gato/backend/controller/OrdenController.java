package com.Gato.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gato.backend.model.Orden;
import com.Gato.backend.service.OrdenService;
@RestController
@RequestMapping("/api/ordenes")
@CrossOrigin(origins = "http://localhost:5173")
public class OrdenController {
    @Autowired
    private OrdenService ordenService;
    
    @GetMapping
    public List<Orden> obtenerlista(Long id){
        return ordenService.obtenerOrden();

    }


}
