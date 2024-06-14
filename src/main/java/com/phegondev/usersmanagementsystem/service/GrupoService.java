package com.phegondev.usersmanagementsystem.service;

import com.phegondev.usersmanagementsystem.entity.*;
import com.phegondev.usersmanagementsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private GestionRepository gestionRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private SistemaacademicoRepository sistemaacademicoRepository;

    public List<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }

    public Optional<Grupo> getGrupoById(Integer id) {
        return grupoRepository.findById(id);
    }



    public Grupo createGrupo(Grupo grupo) {

         Optional<Carrera> carreraOptional = carreraRepository.findById(grupo.getCarrera().getId());
        carreraOptional.ifPresent(grupo::setCarrera);

        Optional<Gestion> gestionOptional = gestionRepository.findById(grupo.getGestion().getId());
        gestionOptional.ifPresent(grupo::setGestion);

        Optional<Materia> materiaOptional = materiaRepository.findById(grupo.getMateria().getId());
        materiaOptional.ifPresent(grupo::setMateria);

        Optional<OurUsers> ourUsersOptional = usersRepo.findById(grupo.getOurUsers().getId());
        ourUsersOptional.ifPresent(grupo::setOurUsers);

        Optional<Sistemaacademico> sistemaacademicoOptional = sistemaacademicoRepository.findById(grupo.getSistemaacademico().getId());
        sistemaacademicoOptional.ifPresent(grupo::setSistemaacademico);

        return grupoRepository.save(grupo);

    }

//    public Optional<Carrera> updateCarrera(Integer id, Carrera carreraDetails) {
//        Optional<Carrera> carrera = carreraRepository.findById(id);
//        if (carrera.isPresent()) {
//            Carrera carreraToUpdate = carrera.get();
//            carreraToUpdate.setNro(carreraDetails.getNro());
//            carreraToUpdate.setNombre(carreraDetails.getNombre());
//            if (carreraDetails.getFacultad() != null && carreraDetails.getFacultad().getId() != null) {
//                Optional<Facultad> facultadOptional = facultadRepository.findById(carreraDetails.getFacultad().getId());
//                facultadOptional.ifPresent(carreraToUpdate::setFacultad);
//            }
//            return Optional.of(carreraRepository.save(carreraToUpdate));
//        } else {
//            return Optional.empty();
//        }
//    }

    public void deleteGrupo(Integer id) {
        grupoRepository.deleteById(id);
    }
}
