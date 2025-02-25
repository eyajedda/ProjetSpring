package tn.esprit.firstspringproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstspringproject.entities.Reservation;

public interface IReservationRepository extends CrudRepository <Reservation, String> {
}
