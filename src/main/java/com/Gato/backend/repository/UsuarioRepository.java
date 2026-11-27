package com.Gato.backend.repository;

import com.Gato.backend.model.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByCorreo(String correo);
    boolean existsByCorreo(String correo);
    boolean existsByRut(String rut);
}