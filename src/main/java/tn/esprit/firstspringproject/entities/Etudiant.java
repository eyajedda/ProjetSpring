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
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String nomEt ;
    private String prenomEt ;
    private long cin ;
    private String ecole;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    // relation bidirectionnelle etudiant reservation (*-*)
    @ManyToMany(cascade = CascadeType.ALL , mappedBy = "etudiants")
    private List<Reservation> reservations ;



}
