package com.phegondev.usersmanagementsystem.controller;

import com.phegondev.usersmanagementsystem.entity.Materia;
import com.phegondev.usersmanagementsystem.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaRepository materiaRepository;

    @GetMapping
    public List<Materia> getAllMaterias() {
        return materiaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable Integer id) {
        Optional<Materia> materia = materiaRepository.findById(id);
        return materia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Materia createMateria(@RequestBody Materia materia) {
        return materiaRepository.save(materia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> updateMateria(@PathVariable Integer id, @RequestBody Materia materiaDetails) {
        Optional<Materia> materia = materiaRepository.findById(id);
        if (materia.isPresent()) {
            Materia updatedMateria = materia.get();
            updatedMateria.setNombre(materiaDetails.getNombre());
            updatedMateria.setSigla(materiaDetails.getSigla());
            return ResponseEntity.ok(materiaRepository.save(updatedMateria));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMateria(@PathVariable Integer id) {
        Optional<Materia> materia = materiaRepository.findById(id);
        if (materia.isPresent()) {
            materiaRepository.delete(materia.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
