package fr.ecoleNum.VehiculeRental.controller;

import fr.ecoleNum.VehiculeRental.exception.ClientIdNotFoundException;
import fr.ecoleNum.VehiculeRental.exception.VehiculeIdNotFoundException;
import fr.ecoleNum.VehiculeRental.model.Client;
import fr.ecoleNum.VehiculeRental.model.Reservation;
import fr.ecoleNum.VehiculeRental.model.Vehicule;
import fr.ecoleNum.VehiculeRental.service.ClientService;
import fr.ecoleNum.VehiculeRental.service.ReservationService;
import fr.ecoleNum.VehiculeRental.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private VehiculeService vehiculeService;

    @Autowired
    private ReservationService reservationService;

    //@Operation(summary = "Créer un véhicule", description = "Rajoute un nouvel objet Vehicule à la base de données.")
    @PostMapping ("/vehicule")
    public ResponseEntity<?> createVehicule(@RequestBody Vehicule vehicule){

        vehiculeService.createVehicule(vehicule);

        return new ResponseEntity<>(vehicule, HttpStatus.CREATED);
    }

    @GetMapping("/vehicules")
    public ResponseEntity<?> getAllVehicules() {
        return new ResponseEntity<>(vehiculeService.getAllVehicules(), HttpStatus.OK);
    }


    @GetMapping("/vehicule/{id}")
    public ResponseEntity<?> retrieveVehicule(@PathVariable("id") final int id) {
        try {
            return new ResponseEntity<>(vehiculeService.getVehicule(id), HttpStatus.OK);
        } catch (VehiculeIdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("vehicule/{id}")
    public ResponseEntity<?> deleteVehicule(@PathVariable("id") final int id) {
        try {
            return new ResponseEntity<>(vehiculeService.deleteVehicule(id), HttpStatus.OK);
        } catch (VehiculeIdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("vehicule/{id}")
    public ResponseEntity<?> modifyVehicule(@PathVariable("id") final int id, @RequestBody Vehicule vehicule) {
        try {
            vehiculeService.modifyVehicule(id, vehicule);
            return new ResponseEntity<>(retrieveVehicule(id), HttpStatus.CREATED);
        } catch (VehiculeIdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping ("/client")
    public ResponseEntity<?> createClient(@RequestBody Client client){

        clientService.createClient(client);

        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @GetMapping("/clients")
    public ResponseEntity<?> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }


    @GetMapping("/client/{id}")
    public ResponseEntity<?> retrieveClient(@PathVariable("id") final int id) {
        try {
            return new ResponseEntity<>(clientService.getClient(id), HttpStatus.OK);
        } catch (ClientIdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("client/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") final int id) {
        try {
            return new ResponseEntity<>(clientService.deleteClient(id), HttpStatus.OK);
        } catch (ClientIdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("client/{id}")
    public ResponseEntity<?> modifyClient(@PathVariable("id") final int id, @RequestBody Client client) {
        try {
            clientService.modifyClient(id, client);
            return new ResponseEntity<>(retrieveClient(id), HttpStatus.CREATED);
        } catch (ClientIdNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("reservation")
    public ResponseEntity<?> createReservation(@RequestBody Reservation reservation) {
        reservationService.createReservation(reservation);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    @GetMapping("/reservations")
    public ResponseEntity<?> getAllReservations() {
        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }



    
}
