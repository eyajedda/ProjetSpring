package tn.esprit.firstspringproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstspringproject.entities.Chambre;
import tn.esprit.firstspringproject.entities.Etudiant;
import tn.esprit.firstspringproject.entities.Reservation;
import tn.esprit.firstspringproject.repositories.IChambreRepository;
import tn.esprit.firstspringproject.repositories.IEtudiantRepository;
import tn.esprit.firstspringproject.repositories.IReservationRepository;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService implements IReservationService{
    @Autowired
    IReservationRepository reservationRepository;
    @Autowired
    IEtudiantRepository etudiantRepository ;
    @Autowired
    IChambreRepository chambreRepository;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getReservationsByAnneeUniversitaireAndUniversite(Date anneeUniversite, String nomUniversite) {
        return reservationRepository.findReservationsByAnneeUniversitaireAndNomUniversite(anneeUniversite , nomUniversite);
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

        Chambre chambre = chambreRepository.findByBlocId(idBloc);

        Reservation reservation = new Reservation();
        reservation.setChambre(chambre);
        reservation.setEtudiant(etudiant);


        return reservationRepository.save(reservation);
    }


    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Reservation reservation = reservationRepository.findByEtudiantCin(cinEtudiant);

        reservation.setEtudiant(null);

        return reservationRepository.save(reservation);
    }



}
