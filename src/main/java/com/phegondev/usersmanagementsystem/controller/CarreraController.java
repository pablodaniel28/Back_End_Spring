package com.phegondev.usersmanagementsystem.controller;

import com.phegondev.usersmanagementsystem.entity.Carrera; // Cambio de Materia a Carrera
import com.phegondev.usersmanagementsystem.service.CarreraService; // Cambio de MateriaService a CarreraService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras") // Cambio de materias a carreras
public class CarreraController { // Cambio de MateriaController a CarreraController

    @Autowired
    private CarreraService carreraService; // Cambio de MateriaService a CarreraService

    @GetMapping // Cambio de GetMapping("/materias") a GetMapping("/carreras")
    public List<Carrera> getAllCarreras() { // Cambio de getAllMaterias a getAllCarreras
        return carreraService.getAllCarreras(); // Cambio de getAllMaterias a getAllCarreras
    }

    @GetMapping("/{id}") // Cambio de GetMapping("/materias/{id}") a GetMapping("/carreras/{id}")
    public ResponseEntity<Carrera> getCarreraById(@PathVariable Integer id) { // Cambio de getMateriaById a getCarreraById
        Optional<Carrera> carrera = carreraService.getCarreraById(id); // Cambio de getMateriaById a getCarreraById
        return carrera.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping // Cambio de PostMapping("/materias") a PostMapping("/carreras")
    public Carrera createCarrera(@RequestBody Carrera carrera) { // Cambio de createMateria a createCarrera
        return carreraService.createCarrera(carrera); // Cambio de createMateria a createCarrera
    }

    @PutMapping("/{id}") // Cambio de PutMapping("/materias/{id}") a PutMapping("/carreras/{id}")
    public ResponseEntity<Carrera> updateCarrera(@PathVariable Integer id, @RequestBody Carrera carreraDetails) { // Cambio de updateMateria a updateCarrera
        Optional<Carrera> carrera = carreraService.updateCarrera(id, carreraDetails); // Cambio de updateMateria a updateCarrera
        return carrera.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}") // Cambio de DeleteMapping("/materias/{id}") a DeleteMapping("/carreras/{id}")
    public ResponseEntity<Void> deleteCarrera(@PathVariable Integer id) { // Cambio de deleteMateria a deleteCarrera
        if (carreraService.getCarreraById(id).isPresent()) { // Cambio de getMateriaById a getCarreraById
            carreraService.deleteCarrera(id); // Cambio de deleteMateria a deleteCarrera
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
