package com.example.msformation.controller;

import com.example.msformation.dao.FormationRepository;
import com.example.msformation.entities.Formation;
import com.example.msformation.proxy.EtudiantProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api")
public class FormationAPI {
    @Autowired
    FormationRepository formationRepository;

    EtudiantProxy etudiantProxy;
    @GetMapping("formation/{id}")
    Formation getFormationWithEtudiants(@PathVariable("id") long idf){
        Formation formation  = formationRepository.findById(idf).get();
        formation.setLesEtudiants(new ArrayList<>(etudiantProxy.g(idf,"toformation").getContent( ) ));
        return formation;
    }


}
