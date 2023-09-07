package fr.ecoleNum.VehiculeRental.service;

import fr.ecoleNum.VehiculeRental.exception.ClientIdNotFoundException;
import fr.ecoleNum.VehiculeRental.model.Client;
import fr.ecoleNum.VehiculeRental.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clients;

    public boolean isAdult(Client client) throws ClientIdNotFoundException {
        return isAdult(client.getId());
    }

    public boolean isAdult(Integer id) throws ClientIdNotFoundException {
        Optional<Client> optionalClient = this.clients.findById(id);

        if (optionalClient.isEmpty()) throw new ClientIdNotFoundException();

        Client client = optionalClient.get();

        // System.currentTimeMillis = function who return today date
        Timestamp actualDate = new Timestamp(System.currentTimeMillis());
        Timestamp clientBirth = client.getBirthDate();

        //compareTo method returns a time in seconds corresponding to actualDate - clientBirth
        Timestamp ageTimestamp = new Timestamp(actualDate.compareTo(clientBirth));
        LocalDateTime ageCustomer = ageTimestamp.toLocalDateTime();

        final int majorityAge = 18;
        return ageCustomer.getYear() >= majorityAge;
    }

    public boolean hasReservationBetween(Timestamp start, Timestamp end) {
        return false;
    }
}
