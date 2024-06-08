package com.phegondev.usersmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "carreras")
@Data
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String nro; // Cambio de "sigla" a "nro"

    public Carrera() {
    }

    public Carrera(Integer id, String nombre, String nro) { // Cambio de "sigla" a "nro"
        this.id = id;
        this.nombre = nombre;
        this.nro = nro; // Cambio de "sigla" a "nro"
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNro() { // Cambio de "sigla" a "nro"
        return nro;
    }

    public void setNro(String nro) { // Cambio de "sigla" a "nro"
        this.nro = nro;
    }
}
