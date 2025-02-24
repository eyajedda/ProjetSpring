package tn.esprit.firstspringproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;

    private String nomBloc ;
    private long capaciteBloc;

    // relation bidirectionnelle foyer bloc (1-*)
    @ManyToOne
    private Foyer foyer;

    // relation bidirectionnelle bloc chambre (1-*)
    @OneToMany (cascade = CascadeType.ALL , mappedBy = "bloc")
    private List<Chambre> chambres ;

}
