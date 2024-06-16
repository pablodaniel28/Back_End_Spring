package com.phegondev.usersmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "facultades")
@Data
public class Facultad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private Double latitud; // Nuevo campo

    @Column(nullable = false)
    private Double longitud; // Nuevo campo

    @Column(nullable = false, unique = true)
    private String nombre;
}