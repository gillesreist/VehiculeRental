package fr.ecoleNum.VehiculeRental.repository;

import fr.ecoleNum.VehiculeRental.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
