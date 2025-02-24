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

    // relation bidirectionnelle etudiant reservation (*-*)
    @ManyToMany
    private List <Etudiant> etudiants ;
}
