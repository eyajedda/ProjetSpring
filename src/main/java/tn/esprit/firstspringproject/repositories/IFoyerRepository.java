package tn.esprit.firstspringproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstspringproject.entities.Foyer;

public interface IFoyerRepository extends CrudRepository<Foyer, Long> {
}
