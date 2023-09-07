package fr.ecoleNum.VehiculeRental.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Reservation {


    @Id
    @ManyToOne
    @JoinColumn(name = "idClient", nullable = false)
    private Client client;

    @Id
    @ManyToOne
    @JoinColumn(name = "idVehicule", nullable = false)
    private Vehicule vehicule;

    @Column(nullable = false)
    private Timestamp startDateReservation;

    @Column(nullable = false)
    private Timestamp endDateReservation;

    public Reservation() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Timestamp getStartDateReservation() {
        return startDateReservation;
    }

    public void setStartDateReservation(Timestamp startDateReservation) {
        this.startDateReservation = startDateReservation;
    }

    public Timestamp getEndDateReservation() {
        return endDateReservation;
    }

    public void setEndDateReservation(Timestamp endDateReservation) {
        this.endDateReservation = endDateReservation;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "client=" + client +
                ", vehicule=" + vehicule +
                ", startDateReservation=" + startDateReservation +
                ", endDateReservation=" + endDateReservation +
                '}';
    }
}
