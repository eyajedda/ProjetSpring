package tn.esprit.firstspringproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstspringproject.entities.Bloc;
import tn.esprit.firstspringproject.entities.Etudiant;
import tn.esprit.firstspringproject.services.IBlocService;

import java.util.List;

@RestController
@RequestMapping("/bloc")
public class BlocController {
    @Autowired
    IBlocService blocService;

    @PostMapping("/getblocs")
    public List<Bloc> getBlocs (){
        return (List<Bloc>) blocService.retrieveBlocs();
    }

    @PostMapping("/addbloc")
    public Bloc addBloc (@RequestBody Bloc bloc){
        return blocService.addBloc(bloc);
    }

    @PostMapping("/updatebloc")
    public Bloc updateBloc (@RequestBody Bloc bloc){
        return blocService.updateBloc(bloc);
    }

    @PostMapping("/getbloc/{id}")
    public Bloc getBloc (@PathVariable("id") long id){
        return blocService.retrieveBloc(id);
    }

    @PostMapping("/removebloc/{id}")
    public void removeBloc (@PathVariable("id") long id){
        blocService.removeBloc(id);
    }





}
