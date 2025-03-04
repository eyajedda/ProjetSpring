package tn.esprit.firstspringproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstspringproject.entities.Etudiant;
import tn.esprit.firstspringproject.entities.Reservation;
import tn.esprit.firstspringproject.services.IEtudiantService;
import tn.esprit.firstspringproject.services.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    IReservationService reservationService;

    @PostMapping("/getreservations")
    public List<Reservation> getReservations (){
        return reservationService.retrieveAllReservation();
    }

    @PostMapping("/updatereservation")
    public Reservation updateReservation (@RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation);
    }

    @PostMapping("/getreservation/{id}")
    public Reservation getReservation (@PathVariable String id){
        return reservationService.retrieveReservation(id);
    }

}
