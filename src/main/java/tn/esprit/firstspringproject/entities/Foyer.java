package tn.esprit.firstspringproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer ;
    private String nomFoyer ;
    private long capaciteFoyer;

    // relation bidirectionnelle foyer bloc (1-*)
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "foyer")
    private List<Bloc> blocs ;

    // relation bidirectionnelle foyer universite (1-1)
    // bout slave
    @OneToOne (mappedBy = "foyer")
    private Universite universite ;
}
