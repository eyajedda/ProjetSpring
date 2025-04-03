package tn.esprit.firstspringproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstspringproject.entities.Bloc;
import tn.esprit.firstspringproject.entities.Chambre;
import tn.esprit.firstspringproject.entities.Etudiant;
import tn.esprit.firstspringproject.entities.Reservation;
import tn.esprit.firstspringproject.repositories.IBlocRepository;
import tn.esprit.firstspringproject.repositories.IChambreRepository;
import tn.esprit.firstspringproject.repositories.IEtudiantRepository;
import tn.esprit.firstspringproject.repositories.IReservationRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationService implements IReservationService{
    @Autowired
    IReservationRepository reservationRepository;
    @Autowired
    IEtudiantRepository etudiantRepository ;
    @Autowired
    IChambreRepository chambreRepository;
    @Autowired
    IBlocRepository blocRepository;
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
        List<Reservation> reservations = reservationRepository.findByAnneeUniversitaireEtNomUniversite(anneeUniversite, nomUniversite);

        if (reservations.isEmpty()) {
            throw new RuntimeException("Aucune réservation trouvée pour l'université: " + nomUniversite + " en " + anneeUniversite);
        }

        System.out.println("✅ Nombre de réservations trouvées: " + reservations.size());
        return reservations;    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        System.out.println("Début de la méthode ajouterReservation");

        // Vérifier si l'étudiant existe
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        if (etudiant == null) {
            throw new RuntimeException("Étudiant non trouvé avec CIN: " + cinEtudiant);
        }

        // Trouver les chambres du bloc
        List<Chambre> chambres = chambreRepository.findByBloc_IdBloc(idBloc);
        System.out.println("Nombre de chambres trouvées dans le bloc " + idBloc + ": " + chambres.size());

        // Filtrer les chambres disponibles en respectant la capacité
        Chambre chambreDisponible = chambres.stream()
                .peek(ch -> System.out.println("Vérification chambre: " + ch.getNumeroChambre()))
                .filter(ch -> {
                    if (ch.getReservations() == null || ch.getTypeC() == null) {
                        System.out.println("⚠️ Chambre " + ch.getNumeroChambre() + " a des données null !");
                        return false;
                    }
                    int nbReservations = ch.getReservations().size();
                    int capacite = ch.getTypeC().getCapacite();

                    System.out.println("Nombre de réservations actuelles: " + nbReservations + " / Capacité: " + capacite);

                    // Vérifier si la chambre est toujours disponible
                    return nbReservations < capacite;
                })
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucune chambre disponible"));

        System.out.println("Chambre disponible trouvée: " + chambreDisponible.getNumeroChambre());

        // Créer la réservation
        Reservation reservation = new Reservation();
        reservation.setIdReservation(UUID.randomUUID().toString());
        reservation.setChambre(chambreDisponible);
        reservation.setEtudiant(etudiant);
        reservation.setEstValide(true);
        reservation.setNumReservation(
                chambreDisponible.getNumeroChambre() + "-" +
                        chambreDisponible.getBloc().getNomBloc() + "-" +
                        LocalDate.now().getYear()
        );
        reservation.setAnneeUniversitaire(new Date());

        System.out.println("Réservation créée avec NumReservation: " + reservation.getNumReservation());

        // Sauvegarder la réservation D'ABORD pour éviter l'erreur TransientObjectException
        reservation = reservationRepository.save(reservation);
        System.out.println("Réservation enregistrée avec succès: " + reservation.getIdReservation());

        // Maintenant que la réservation a un ID, on peut l'ajouter à la chambre et sauvegarder la chambre
        chambreDisponible.getReservations().add(reservation);
        chambreRepository.save(chambreDisponible);

        System.out.println("Capacité de la chambre mise à jour après réservation");

        return reservation;
    }


    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        System.out.println("Début de la méthode annulerReservation pour CIN: " + cinEtudiant);

        // Trouver la réservation active de l'étudiant
        Reservation reservation = reservationRepository.findByEtudiant_CinAndEstValide(cinEtudiant, true);
        if (reservation == null) {
            throw new RuntimeException("Aucune réservation active trouvée pour l'étudiant avec CIN: " + cinEtudiant);
        }

        // Marquer la réservation comme invalide
        reservation.setEstValide(false);

        // Désaffecter l'étudiant et la chambre
        reservation.setEtudiant(null);
        Chambre chambre = reservation.getChambre();
        reservation.setChambre(null);

        // Sauvegarde des modifications
        reservationRepository.save(reservation);

        System.out.println("Réservation annulée avec succès pour l'étudiant CIN: " + cinEtudiant);

        return reservation;
    }



}
