package com.covoiturage.testjpa;

import com.covoiturage.testjpa.entities.Patient;
import com.covoiturage.testjpa.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TestJpaApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(TestJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"levesque","Akouvi",new Date(),276,true,"levesque.akouvi@gmail.com"));
        patientRepository.save(new Patient(null,"rolland","garos",new Date(),232,false,"roland.garos@yahoo.com"));
        patientRepository.save(new Patient(null,"Langlois","Veronique",new Date(),3223,true,"llanglois.veronique@ulaval.ca"));
        patientRepository.save(new Patient(null,"frederic","dubois",new Date(),443,false,"frederic.dubois@hotmail.com.com"));
        patientRepository.save(new Patient(null,"Messi","leonel",new Date(),553,false,"messi.leonel@messi.com"));
        patientRepository.save(new Patient(null,"ronaldo","cristiano",new Date(),553,false,"ronaldo.cristiano@gmail.com"));
        patientRepository.save(new Patient(null,"messanh","king",new Date(),443,false,"messanh.king@king.com"));
        patientRepository.save(new Patient(null,"lukaku","jean",new Date(),4435,false,"lukaku@gmail.com"));
        patientRepository.save(new Patient(null,"benoit","bob",new Date(),8877,true,"benoit.bobi@gmail.com"));
        patientRepository.save(new Patient(null,"François","akitani",new Date(),8800,true,"françois.akitani.com"));
        /**
         * pour afficher tous les patients;
         */
        System.out.println("La liste de tous les patients dans la base de données.");
        System.out.println("===========================================================");
        patientRepository.findAll().forEach(p ->{
            System.out.println(p.toString());
        } );

        /**
         * trouver un patien par son id
         */
        System.out.println("La liste de patient selon son identifiant.");
        System.out.println("===========================================================");
        Patient patient=patientRepository.findById(4l).get();
        System.out.println(patient.getNom());

        /**
         * obtenir la liste de patient donc le nom possede un caractere donné.
         */
        System.out.println("La liste de tous les patients dans la base de données ayant un type de caratère dans leur nom.");
        System.out.println("===========================================================");
        var patient1=patientRepository.findByNomContains("e");
        patient1.forEach(p ->{
            System.out.println(p.toString());
        } );

        /**
         * liste des patient qui sont malades
         */

        System.out.println("La liste des patient qui sont malade.");
        System.out.println("===========================================================");
        List<Patient> patientMalade = patientRepository.findByMalade(true);
        patientMalade.forEach(p->{
            System.out.println(p.toString());
        } );

        /**
         * liste des patients malade et ayant un caratere dans leur nom.
         */

        System.out.println("La liste des patients malade et ayant un caractere dans leur nom.");
        System.out.println("===========================================================");
        List<Patient>patientListMalade = patientRepository.findByNomContainsAndMalade("m",true);
        patientListMalade.forEach(p ->{
            System.out.println(p.toString());
        } );

        /**
         * pour supprimer un patient.
         */
       // patientRepository.deleteById(4l);

        /**
         * la pagination.
         */
        System.out.println("affichage par page.");
        System.out.println("===========================================================");
        Page<Patient> patientPage = patientRepository.findByNomContains("a", PageRequest.of(0,3));
        patientPage.getContent().forEach(p ->{
            System.out.println(p.toString());
        } );

        Page<Patient>patientPageTotale = patientRepository.findAll(PageRequest.of(0,2));
        System.out.println("le nombre total des page est : "+patientPageTotale.getTotalPages());



    }
}
