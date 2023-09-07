package fr.ecoleNum.VehiculeRental.repository;

import fr.ecoleNum.VehiculeRental.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
