package tn.esprit.firstspringproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstspringproject.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationRepository extends CrudRepository <Reservation, String> {

    @Query("SELECT r FROM Reservation r " +
            "JOIN r.chambre c JOIN c.bloc b JOIN b.foyer f JOIN f.universite u " +
            "WHERE u.nomUniversite = :nomUniversite " +
            "AND FUNCTION('YEAR', r.anneeUniversitaire) = FUNCTION('YEAR', :anneeUniversitaire)")
    List<Reservation> findReservationsByAnneeUniversitaireAndNomUniversite(Date anneeUniversitaire, String nomUniversite);


    public Reservation findByEtudiantCin(long cinEtudiant);
}

