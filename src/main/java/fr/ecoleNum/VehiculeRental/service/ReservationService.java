package fr.ecoleNum.VehiculeRental.service;
import fr.ecoleNum.VehiculeRental.model.Reservation;
import fr.ecoleNum.VehiculeRental.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public void createReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public Iterable<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
