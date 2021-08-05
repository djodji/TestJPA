package com.covoiturage.testjpa.repositories;

import com.covoiturage.testjpa.entities.Patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    public List<Patient> findByNomContains(String caractere);
    public List<Patient> findByMalade(boolean b);
    public List<Patient> findByNomContainsAndMalade(String caractere, boolean b);

    Page<Patient>findByNomContains(String caractere2, Pageable pageable);
}
