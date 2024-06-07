package com.phegondev.usersmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "docente")
@Data
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer ci;

    @Column(nullable = false, unique = true)
    private String codigo;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private OurUsers usuario;

    public Docente() {
    }

    public Docente(Integer id, String nombre, Integer ci, String codigo, OurUsers usuario) {
        this.id = id;
        this.nombre = nombre;
        this.ci = ci;
        this.codigo = codigo;
        this.usuario = usuario;
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

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public OurUsers getUsuario() {
        return usuario;
    }

    public void setUsuario(OurUsers usuario) {
        this.usuario = usuario;
    }
}