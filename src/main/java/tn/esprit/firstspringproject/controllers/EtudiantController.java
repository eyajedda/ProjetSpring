package tn.esprit.firstspringproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstspringproject.entities.Bloc;
import tn.esprit.firstspringproject.entities.Etudiant;
import tn.esprit.firstspringproject.entities.Foyer;
import tn.esprit.firstspringproject.services.IBlocService;
import tn.esprit.firstspringproject.services.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    IEtudiantService etudiantService;

    @GetMapping("/getetudiants")
    public List<Etudiant> getEtudiants (){
        return (List<Etudiant>) etudiantService.retrieveAllEtudiants();
    }

    @PostMapping("/addetudiants")
    public List<Etudiant> addEtudiants (@RequestBody List<Etudiant> etudiants){
        return (List<Etudiant>) etudiantService.addEtudiants(etudiants);
    }

    @PutMapping("/updateetudiant")
    public Etudiant updateEtudiant (@RequestBody Etudiant etudiant){
        return etudiantService.updateEtudiant(etudiant);
    }

    @GetMapping("/getetudiant/{id}")
    public Etudiant getEtudiant (@PathVariable("id") long id){
        return etudiantService.retrieveEtudiant(id);
    }

    @DeleteMapping("/removeetudiant/{id}")
    public void removeEtudiant (@PathVariable("id") long id){
        etudiantService.removeEtudiant(id);
    }
}
