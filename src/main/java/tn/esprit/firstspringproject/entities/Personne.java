package tn.esprit.firstspringproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private int age;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    // pour stocker la valeur sous forme de chaine de caractere , non pas en chiffres
    @Enumerated(value = EnumType.STRING)
    private Gender gender ;
}
