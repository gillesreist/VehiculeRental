package fr.ecoleNum.VehiculeRental.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity @IdClass(ReservationId.class)
public class Reservation implements Serializable {


    @Id
    @ManyToOne
    @JoinColumn( nullable = false)
    private Client client;

    @Id
    @ManyToOne
    @JoinColumn( nullable = false)
    private Vehicule vehicule;

    public ReservationId getId() {
        return new ReservationId(client, vehicule, new Timestamp(0));
    }
    public void setId(ReservationId id) {
        this.client = id.getClient();
        this.vehicule = id.getVehicule();
    }

    @Id
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
