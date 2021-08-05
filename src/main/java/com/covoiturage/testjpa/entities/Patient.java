package com.covoiturage.testjpa.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Table(name = "PATIENT")
@Entity //pour déclarer la classe comme étant la table
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient {
    /**
     * id est l'identifiant unique de la table patient
     * et generatedValue permet de generer automatiquement les valeurs.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NomFamille", length = 40)
    private String nom;

    @Column(name = "Prénom",length = 40)
    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateDeNaissance;

    private int score;
    private boolean malade;

    private String adresseMail;
}
