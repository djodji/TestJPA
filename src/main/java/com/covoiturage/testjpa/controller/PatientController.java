package com.covoiturage.testjpa.controller;

import com.covoiturage.testjpa.entities.Patient;
import com.covoiturage.testjpa.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PatientController {
    /**
     * le controlleur ira chercher des information dans la base de données pour ensuite les
     * afficher a l'écran.
     * faut donc instancier le patientRepository
     */
    @Autowired
    private PatientRepository patientRepository;

    /**
     * pour obtenir la liste des patient en fichiers jason
     * @return
     */
    @GetMapping("/patients")
    public List<Patient> patientListController(){
        return patientRepository.findAll();
    }

    /**
     * pour acceder aux information d'un patient via son id.
     */
    @GetMapping("/patients/{id}")
    public Patient patient(@PathVariable Long id)
    {
        return patientRepository.findById(id).get();
    }

    /**
     * trouver les patients qui sont malade dans la liste
     * @param b
     * @return
     */
    @GetMapping("/patient/{b}")
    public List<Patient> patientMalade(@PathVariable boolean b){
        return patientRepository.findByMalade(b);
    }



}
