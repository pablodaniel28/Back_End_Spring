package com.phegondev.usersmanagementsystem.service;

import com.phegondev.usersmanagementsystem.entity.Carrera; // Cambio de Materia a Carrera
import com.phegondev.usersmanagementsystem.repository.CarreraRepository; // Cambio de MateriaRepository a CarreraRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraService { // Cambio de MateriaService a CarreraService

    @Autowired
    private CarreraRepository carreraRepository; // Cambio de MateriaRepository a CarreraRepository

    public List<Carrera> getAllCarreras() { // Cambio de getAllMaterias a getAllCarreras
        return carreraRepository.findAll(); // Cambio de findAll() a findAll()
    }

    public Optional<Carrera> getCarreraById(Integer id) { // Cambio de getMateriaById a getCarreraById
        return carreraRepository.findById(id); // Cambio de findById a findById()
    }

    public Carrera createCarrera(Carrera carrera) { // Cambio de createMateria a createCarrera
        return carreraRepository.save(carrera); // Cambio de save a save()
    }

    public Optional<Carrera> updateCarrera(Integer id, Carrera carreraDetails) { // Cambio de updateMateria a updateCarrera
        return carreraRepository.findById(id).map(carrera -> { // Cambio de findById a findById()
            carrera.setNombre(carreraDetails.getNombre());
            carrera.setNro(carreraDetails.getNro());
            return carreraRepository.save(carrera); // Cambio de save a save()
        });
    }

    public void deleteCarrera(Integer id) { // Cambio de deleteMateria a deleteCarrera
        carreraRepository.deleteById(id); // Cambio de deleteById a deleteById()
    }
}
