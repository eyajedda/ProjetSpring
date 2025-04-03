package tn.esprit.firstspringproject.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstspringproject.entities.*;
import tn.esprit.firstspringproject.services.IReservationService;
import tn.esprit.firstspringproject.services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteController {
    @Autowired
    IUniversiteService universiteService;

    @GetMapping("/getuniversites")
    public List<Universite> getUniversites (){
        return universiteService.retrieveAllUniversities();
    }

    @PostMapping("/adduniversite")
    public Universite addUniversite (@RequestBody Universite universite){
        return universiteService.addUniversite(universite);
    }

    @GetMapping("/getuniversite/{id}")
    public Universite getUniversite (@PathVariable Long id){
        return universiteService.retrieveUniversite(id);
    }

    @PutMapping("/updateuniversite")
    public Universite updateUniversite (@RequestBody Universite universite){
        return universiteService.updateUniversite(universite);
    }

    @PutMapping("/affecter-foyer/{idFoyer}/{nomUniversite}")
    @JsonIgnore
    public Universite affecterFoyerAUniversite(
            @PathVariable long idFoyer,
            @PathVariable String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PutMapping("/desaffecter-foyer/{idUniversite}")
    public Universite desaffecterFoyerAUniversite (@PathVariable long idUniversite){
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }




    }
