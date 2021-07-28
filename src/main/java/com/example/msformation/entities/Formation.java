package com.example.msformation.entities;

import com.example.msformation.model.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor
public class Formation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idFormation;
    private String nom;
    private int duree;

 @Transient
 private List<Etudiant> lesEtudiants;
    public Formation() {

    }
}
