package fr.ecoleNum.VehiculeRental.service;

import fr.ecoleNum.VehiculeRental.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clients;

    public boolean isAdult() {
        return true;
    }

    public boolean hasReservationBetween(Timestamp start, Timestamp end) {
        return false;
    }
}
