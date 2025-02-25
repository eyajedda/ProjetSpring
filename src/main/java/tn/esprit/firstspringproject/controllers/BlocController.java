package tn.esprit.firstspringproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.firstspringproject.entities.Bloc;
import tn.esprit.firstspringproject.services.IBlocService;

@RestController
@RequestMapping("/bloc")
public class BlocController {
    @Autowired
    IBlocService blocService;

    @PostMapping("/addbloc")
    public Bloc addBloc (@RequestBody Bloc bloc){
        return blocService.addBloc(bloc);
    }

}
