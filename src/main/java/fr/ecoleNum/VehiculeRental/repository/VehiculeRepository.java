package fr.ecoleNum.VehiculeRental.repository;

import fr.ecoleNum.VehiculeRental.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {
}
