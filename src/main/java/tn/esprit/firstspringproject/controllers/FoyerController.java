package tn.esprit.firstspringproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstspringproject.entities.Bloc;
import tn.esprit.firstspringproject.entities.Foyer;
import tn.esprit.firstspringproject.services.IBlocService;
import tn.esprit.firstspringproject.services.IFoyerService;

import java.util.List;

@RestController
@RequestMapping("/foyer")
public class FoyerController {
    @Autowired
    IFoyerService foyerService;

    @GetMapping("/getfoyers")
    public List<Foyer> getFoyers (){
        return (List<Foyer>) foyerService.retrieveAllFoyers();
    }

    @PostMapping("/addfoyer")
    public Foyer addFoyer (@RequestBody Foyer foyer){
        return foyerService.addFoyer(foyer);
    }

    @PutMapping("/updatefoyer")
    public Foyer updateFoyer (@RequestBody Foyer foyer){
        return foyerService.updateFoyer(foyer);
    }

    @GetMapping("/getfoyer/{id}")
    public Foyer getFoyer (@PathVariable("id") long id){
        return foyerService.retrieveFoyer(id);
    }

    @DeleteMapping("/removefoyer/{id}")
    public void removeFoyer (@PathVariable("id") long id){
        foyerService.removeFoyer(id);
    }

    @PostMapping("/ajouter/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable long idUniversite) {
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }





}
