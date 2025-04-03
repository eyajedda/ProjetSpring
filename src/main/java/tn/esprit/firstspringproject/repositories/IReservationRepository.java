package tn.esprit.firstspringproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.firstspringproject.entities.Chambre;
import tn.esprit.firstspringproject.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationRepository extends CrudRepository <Reservation, String> {

    @Query("SELECT r FROM Reservation r WHERE r.anneeUniversitaire = :anneeUniversite " +
            "AND r.chambre.bloc IN (SELECT b FROM Bloc b WHERE b.foyer IN " +
            "(SELECT f FROM Foyer f WHERE f.universite.nomUniversite = :nomUniversite))")
    List<Reservation> findByAnneeUniversitaireEtNomUniversite(@Param("anneeUniversite") Date anneeUniversite,
                                                              @Param("nomUniversite") String nomUniversite);



    Reservation findByEtudiant_CinAndEstValide(long cin, boolean estValide);
}

