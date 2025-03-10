package tn.esprit.firstspringproject.controllers;

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




}
