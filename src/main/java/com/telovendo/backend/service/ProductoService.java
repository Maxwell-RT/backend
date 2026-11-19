package com.telovendo.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telovendo.backend.model.Producto;
import com.telovendo.backend.repository.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
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

    ///Guardar producto en la db
    public Producto guardar(Producto producto) {
        //no puede ser nulo
        if (producto == null)
            throw new IllegalArgumentException("El producto no puede ser nulo");
        //debe tener un nombre
        if(producto.getNombre() == null || producto.getNombre().trim().isEmpty())
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío");

        //debe tener un precio válido
        if(producto.getPrecio() <= 0 || producto.getPrecio() == null)
            throw new IllegalArgumentException("El precio del producto debe ser mayor a cero");

        if(producto.getUrlImagen() == null || producto.getUrlImagen().trim().isEmpty())
            throw new IllegalArgumentException("La URL de la imagen no puede ser nula o vacía");

        return productoRepository.save(producto);
    }

    //Actualizar producto en la db
    public Producto actualizar(Long id, Producto nuevosdatos) {
        //primero el producto deber existir
        Producto producto = obtenerporId(id);
        //si lo esta, debe comprobarse
        if(nuevosdatos.getNombre() != null && !nuevosdatos.getNombre().trim().isEmpty())
            producto.setNombre(nuevosdatos.getNombre());
        //modificacion en descripcion
        if(nuevosdatos.getDescripcion() != null && !nuevosdatos.getDescripcion().trim().isEmpty())
            producto.setDescripcion(nuevosdatos.getDescripcion());

        //modificacion en precio
        if(nuevosdatos.getPrecio() > 0f && nuevosdatos.getPrecio() != null)
            producto.setPrecio(nuevosdatos.getPrecio());



        return productoRepository.save(producto);
    }


    //Eliminar producto en la db
    public void eliminar(Long id) {
        if(productoRepository.existsById(id)== false)
            throw new RuntimeException("Producto no encontrado por id: " + id);
    
        productoRepository.deleteById(id);
    }
}
