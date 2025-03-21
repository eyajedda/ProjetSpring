package tn.esprit.firstspringproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstspringproject.entities.Etudiant;
import tn.esprit.firstspringproject.entities.Reservation;
import tn.esprit.firstspringproject.services.IEtudiantService;
import tn.esprit.firstspringproject.services.IReservationService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    IReservationService reservationService;

    @GetMapping("/getreservations")
    public List<Reservation> getReservations (){
        return reservationService.retrieveAllReservation();
    }

    @PutMapping("/updatereservation")
    public Reservation updateReservation (@RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation);
    }

    @GetMapping("/getreservation/{id}")
    public Reservation getReservation (@PathVariable String id){
        return reservationService.retrieveReservation(id);
    }

    @GetMapping ("/getRbyAnneeAndUniversite")
    public List<Reservation> getReservationsByAnneeUniversitaireAndUniversite(@RequestParam Date anneeUniversite, @RequestParam String nomUniversite){
        return reservationService.getReservationsByAnneeUniversitaireAndUniversite(anneeUniversite, nomUniversite);
    }

    @PostMapping("/ajouter/{idBloc}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable long idBloc, @PathVariable long cinEtudiant) {
        return reservationService.ajouterReservation(idBloc, cinEtudiant);
    }


    @DeleteMapping("/annuler/{cinEtudiant}")
    public Reservation annulerReservation(@PathVariable long cinEtudiant) {
        return reservationService.annulerReservation(cinEtudiant);
    }


}
