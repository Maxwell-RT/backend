package com.Gato.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gato.backend.model.Usuario;
import com.Gato.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    ///Listado de usuarios
    public List<Usuario> obtenerusuarios(){
        return usuarioRepository.findAll();
    }

    //obtener por id
    public Usuario sacarporId(Long id){
        return usuarioRepository.findById(id).
            orElseThrow(() -> new RuntimeException("Usuario no encontrado por id: " + id));
    } 


 
    ///Crear usuarios
    public Usuario save(Usuario usuario){
        //no puede ser nulo
        if (usuario == null)
            throw new IllegalArgumentException ("El usuario no puede ser nulo");
        //debe tener un nombre
        if(usuario.getNombres() == null || usuario.getNombres().trim().isEmpty())
            throw new IllegalArgumentException("El nombre del usuario no puede ser nulo o vacío");
        //debe tener correo
        if(usuario.getCorreo() == null || usuario.getCorreo().trim().isEmpty())
            throw new IllegalArgumentException("El correo no puede ser nulo");
        //Debe tener contraseña
        if(usuario.getContraseña()==null || usuario.getContraseña().trim().isEmpty())
            throw new IllegalArgumentException("La contraseña no puede estar vacia");
        //debe tener rut
        if(usuario.getRut()==null || usuario.getRut().trim().isEmpty())
            throw new IllegalArgumentException("El rut no puede estar vacio");
        return usuarioRepository.save(usuario);

}

    public Usuario updateuser(Long id, Usuario nuevaInfo){
        //Revisamos la existencia del usuario
        Usuario usuario = sacarporId(id);
        //vamos a comprobar por nombre
        if(nuevaInfo.getNombres() != null && !nuevaInfo.getNombres().trim().isEmpty())
            usuario.setNombres(nuevaInfo.getNombres());
        //vamos a comprobar por correo
        if(nuevaInfo.getCorreo() != null && !nuevaInfo.getCorreo().trim().isEmpty())
            usuario.setCorreo(nuevaInfo.getCorreo());
        //Y ahora a cambiar la contraseña
        if(nuevaInfo.getContraseña() !=null && !nuevaInfo.getContraseña().trim().isEmpty())
            usuario.setContraseña(nuevaInfo.getContraseña());

        return usuarioRepository.save(save(nuevaInfo));
    }

    

    //Eliminar usuario
    public void EliminarUsuario(Long id){
        if(usuarioRepository.existsById(id)==false)
            throw new RuntimeException("Usuario no encontrado" + id);
        usuarioRepository.deleteById(id);
    }

}

