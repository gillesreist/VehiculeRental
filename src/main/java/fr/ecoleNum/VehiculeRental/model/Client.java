package fr.ecoleNum.VehiculeRental.model;


import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Client {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Integer id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Timestamp birthDate;

    @Column(unique = true, nullable = false)
    private Integer drivingLicenseNumber;

    @OneToMany( targetEntity = Reservation.class, mappedBy = "client")
    private List<Reservation> clientReservations = new ArrayList<>();
    public Client(){}
    public Client(Timestamp birth) {
        this.id = null;
        this.firstName = null;
        this.lastName = null;
        this.birthDate = birth;
        this.drivingLicenseNumber = 0;
        this.clientReservations = null;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(Integer drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    @Override
    public String toString() {
        return "Client {" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", DrivingLicenseNumber=" + drivingLicenseNumber +
                '}';
    }
}
