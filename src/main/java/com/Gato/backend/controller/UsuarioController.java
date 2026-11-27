package com.Gato.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gato.backend.model.Usuario;
import com.Gato.backend.service.UsuarioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuariosService;

        //obtener los usuarios disponibles
    @GetMapping
    public List<Usuario> obtenerusuario(){
        return usuariosService.obtenerusuarios();
    }
    
    //Crear usuarios
    @PostMapping
    public Usuario crearusuario(@RequestBody Usuario usuario){
        return usuariosService.save(usuario);
    }
    
    //modificar usuarios por id
    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id,@RequestBody Usuario cambios){
        return usuariosService.updateuser(id, cambios);
    }

    //borrar usuarios por id
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id ){
        usuariosService.EliminarUsuario(id);
    }

}
