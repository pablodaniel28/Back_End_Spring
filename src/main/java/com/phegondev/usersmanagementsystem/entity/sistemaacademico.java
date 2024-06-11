package com.phegondev.usersmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sistemaacademico")
@Data
public class sistemaacademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nombre;
}
