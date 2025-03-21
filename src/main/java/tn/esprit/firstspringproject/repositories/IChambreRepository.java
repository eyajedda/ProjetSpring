package tn.esprit.firstspringproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstspringproject.entities.Chambre;
import tn.esprit.firstspringproject.entities.TypeChambre;

import java.util.List;

public interface IChambreRepository extends CrudRepository<Chambre, Long> {
    /*
    affichage des chambres non réservées ,par typeChambre , appartenant à un foyer
    donné par son nom, effectué durant l’année universitaire actuelle
     */

    @Query("SELECT c FROM Chambre c " +
            "JOIN c.bloc b JOIN b.foyer f JOIN f.universite u " +
            "WHERE u.nomUniversite = :nomUniversite " +
            "AND c.typeC = :type " +
            "AND c NOT IN (SELECT r.chambre FROM Reservation r WHERE r.anneeUniversitaire = FUNCTION('YEAR', CURRENT_DATE))")
    List<Chambre> findChambresNonReservees(String nomUniversite, TypeChambre type);

    // JPQL Query
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> findChambresByBlocAndTypeJPQL(long idBloc, TypeChambre typeC);

    // Spring Data JPA Keywords
    List<Chambre> findByBlocIdBlocAndTypeC(long idBloc, TypeChambre typeC);

    List<Chambre> findAllByIdChambre (List<Long> numChambres);

    Chambre findByBlocId(long idBloc);

    List<Chambre> findByUniversiteNom(String nomUniversite);

}
