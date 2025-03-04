package tn.esprit.firstspringproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstspringproject.entities.Bloc;
import tn.esprit.firstspringproject.entities.Chambre;
import tn.esprit.firstspringproject.services.IBlocService;
import tn.esprit.firstspringproject.services.IChambreService;

import java.util.List;

@RestController
@RequestMapping("/chambre")
public class ChambreController {
    @Autowired
    IChambreService chambreService;

    @PostMapping("/getchambres")
    public List<Chambre> getChambres (){
        return (List<Chambre>) chambreService.retrieveAllChambres();
    }

    @PostMapping("/addchambre")
    public Chambre addChambre (@RequestBody Chambre chambre){
        return chambreService.addChambre(chambre);
    }

    @PostMapping("/updatechambre")
    public Chambre updateChambre (@RequestBody Chambre chambre){
        return chambreService.updateChambre(chambre);
    }

    @PostMapping("/getchambre/{id}")
    public void getChambre (@PathVariable("id") long id){
        chambreService.retrieveChambre(id);
    }





}
