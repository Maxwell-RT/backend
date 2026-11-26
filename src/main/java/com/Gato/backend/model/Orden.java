package com.Gato.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordenes")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idorden;
    @Column(nullable = false)
    private String detalles;
    private String nombrelibro;
    @Column(nullable = false)
    private Float preciolibro;

    public Orden() {

    }

    public Orden(String detalles, String nombrelibro, Float preciolibro) {
        this.detalles = detalles;
        this.nombrelibro = nombrelibro;
        this.preciolibro = preciolibro;
    }

    public Long getIdorden() {
        return idorden;
    }

    public void setIdorden(Long idorden) {
        this.idorden = idorden;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getNombrelibro() {
        return nombrelibro;
    }

    public void setNombrelibro(String nombrelibro) {
        this.nombrelibro = nombrelibro;
    }

    public Float getPreciolibro() {
        return preciolibro;
    }

    public void setPreciolibro(Float preciolibro) {
        this.preciolibro = preciolibro;
    }

}
