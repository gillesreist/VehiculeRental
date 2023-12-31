package fr.ecoleNum.VehiculeRental.service;

import fr.ecoleNum.VehiculeRental.exception.VehiculeIdNotFoundException;
import fr.ecoleNum.VehiculeRental.model.Vehicule;
import fr.ecoleNum.VehiculeRental.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class VehiculeService {

@Autowired
    private VehiculeRepository vehiculeRepository;

    public boolean isReservedBetween(int id, Timestamp start, Timestamp end) {
        return false;
    }

    public void createVehicule(Vehicule vehicule) {
        vehiculeRepository.save(vehicule);
    }

    public Iterable<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    public Vehicule getVehicule(int id) throws VehiculeIdNotFoundException {
        Optional<Vehicule> vehicule =  vehiculeRepository.findById(id);
        if (vehicule.isPresent()) {
            return vehicule.get();
        } else {
            throw new VehiculeIdNotFoundException("Vehicule not found.");
        }
    }

    public Vehicule deleteVehicule(int id) throws VehiculeIdNotFoundException {
        Vehicule vehicule = getVehicule(id);
        vehiculeRepository.deleteById(id);
        return vehicule;
    }

    public void modifyVehicule(int id, Vehicule newProperties) throws VehiculeIdNotFoundException {
       Vehicule vehicule = getVehicule(id);
        if (newProperties.getBrand()!=null){
            vehicule.setBrand(newProperties.getBrand());
        }
        if (newProperties.getColor()!=null){
            vehicule.setColor(newProperties.getColor());
        }
        if (newProperties.getModel()!=null){
            vehicule.setModel(newProperties.getModel());
        }
        if (newProperties.getRegistration()!=null){
            vehicule.setRegistration(newProperties.getRegistration());
        }
        if (newProperties.getKmRate()!=0){
            vehicule.setKmRate(newProperties.getKmRate());
        }
        if (newProperties.getReservationRate()!=0){
            vehicule.setReservationRate(newProperties.getReservationRate());
        }
        if (newProperties.getTaxHorsepower()!=0){
            vehicule.setTaxHorsepower(newProperties.getTaxHorsepower());
        }

       createVehicule(vehicule);
    }


}
