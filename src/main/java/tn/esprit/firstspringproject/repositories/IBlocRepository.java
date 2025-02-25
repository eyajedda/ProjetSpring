package tn.esprit.firstspringproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstspringproject.entities.Bloc;

public interface IBlocRepository extends CrudRepository<Bloc , Long> {
}
