package fr.ecoleNum.VehiculeRental.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;


public class ReservationId implements Serializable {
    private Client client;
    private Vehicule vehicule;

    private Timestamp startDateReservation;

    public ReservationId() {
    }

    public ReservationId(Client client, Vehicule vehicule, Timestamp startDateReservation) {
        this.client = client;
        this.vehicule = vehicule;
        this.startDateReservation = startDateReservation;
    }

    public Client getClient() {
        return client;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }


    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        ReservationId pk = (ReservationId) o;
        return Objects.equals(client, pk.client) &&
                Objects.equals(vehicule, pk.vehicule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, vehicule);
    }
}
