package tn.esprit.firstspringproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {
    @Id
    private String idReservation ;

    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;
    private boolean estValide;

    private String numReservation;
    // relation bidirectionnelle etudiant reservation (*-*)
    @ManyToMany
    private List <Etudiant> etudiants ;

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;


    public void setIdReservation (String id) {
        this.idReservation = id;
    }

    public String getIdReservation () {
        return this.idReservation;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }

    public void setNumReservation(String numReservation) {
        this.numReservation = numReservation;
    }

    public void setAnneeUniversitaire(Date anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }
}
