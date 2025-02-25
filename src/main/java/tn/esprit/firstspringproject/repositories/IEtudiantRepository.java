package tn.esprit.firstspringproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstspringproject.entities.Etudiant;

public interface IEtudiantRepository extends CrudRepository<Etudiant, Long> {
}
