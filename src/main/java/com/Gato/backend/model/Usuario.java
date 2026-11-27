package com.Gato.backend.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nombres;
    private String correo;
    private String contraseña;
    private String rut;

    // ManyToMany: Le indica a JPA que esta relación es de muchos a muchos.
    // fetch = FetchType.EAGER: Controla en qué momento Hibernate va a buscar
    // los roles a la base de datos cuando consultas un usuario
    // EAGER (carga inmediata), apenas buscas un usuario por su correo para el
    // login o para validar un JWT, Hibernate trae al usuario junto con todos
    // sus roles al instante
    @ManyToMany(fetch = FetchType.EAGER)
    // Define la estructura física de la tabla intermedia que
    // Hibernate creará en PostgreSQL:
    @JoinTable(
            // Nombre que tendrá la tabla puente en la base de datos
            name = "usuario_roles",
            // Crea la columna clave foránea (Foreign Key) que apunta a
            // la entidad actual donde estás parado
            joinColumns = @JoinColumn(name = "usuario_id"),
            // Crea la columna clave foránea que apunta a la
            // otra entidad de la relación (Rol).
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    // Un Set (conjunto) en Java no permite duplicados.
    // Esto garantiza que un mismo usuario nunca tenga asignado
    // dos veces el mismo rol (como dos veces ROLE_CLIENTE).
    private Set<Rol> roles = new HashSet<>(); // new HashSet<>() Para que el
                                              // conjunto nazca vacío en lugar de null

    public Usuario() {

    }

    public Usuario(String nombres, String correo, String contraseña, String rut) {
        this.nombres = nombres;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public long getIdusuario() {
        return id;
    }

    public void setIdusuario(long idusuario) {
        this.id = idusuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    
    public Set<Rol> getRoles() { return roles; }
    public void setRoles(Set<Rol> roles) { this.roles = roles; }

}
