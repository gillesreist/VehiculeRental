package fr.ecoleNum.VehiculeRental.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Vehicule {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private int id;

    @Column(unique = true, nullable = false)
    private String registration;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private int reservationRate;

    @Column(nullable = false)
    private int kmRate;

    @Column(nullable = false)
    private int taxHorsepower;

    @OneToMany( targetEntity = Reservation.class, mappedBy = "vehicule")
    private List<Reservation> vehiculeReservations = new ArrayList<>();

    public Vehicule(){};

    public int getId() {
        return id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getReservationRate() {
        return reservationRate;
    }

    public void setReservationRate(int reservationRate) {
        this.reservationRate = reservationRate;
    }

    public int getKmRate() {
        return kmRate;
    }

    public void setKmRate(int kmRate) {
        this.kmRate = kmRate;
    }

    public int getTaxHorsepower() {
        return taxHorsepower;
    }

    public void setTaxHorsepower(int taxHorsepower) {
        this.taxHorsepower = taxHorsepower;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", registration='" + registration + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", reservationRate=" + reservationRate +
                ", kmRate=" + kmRate +
                ", taxHorsepower=" + taxHorsepower +
                ", vehiculeReservations=" + vehiculeReservations +
                '}';
    }
}
