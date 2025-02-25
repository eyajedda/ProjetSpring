package tn.esprit.firstspringproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstspringproject.entities.Chambre;

public interface IChambreRepository extends CrudRepository<Chambre, Long> {
}
