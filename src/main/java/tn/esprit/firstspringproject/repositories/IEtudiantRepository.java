package tn.esprit.firstspringproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstspringproject.entities.Etudiant;

public interface IEtudiantRepository extends CrudRepository<Etudiant, Long> {

public Etudiant findEtudiantByIdEtudiant(long id);
}
