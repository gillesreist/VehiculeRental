package fr.ecoleNum.VehiculeRental.service;

import fr.ecoleNum.VehiculeRental.exception.ClientIdNotFoundException;
import fr.ecoleNum.VehiculeRental.model.Client;
import fr.ecoleNum.VehiculeRental.repository.ClientRepository;

import static fr.ecoleNum.VehiculeRental.service.util.DateFunctions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public boolean isAdult(Client client) throws ClientIdNotFoundException {
        return isAdult(client.getId());
    }

    public boolean isAdult(Integer id) throws ClientIdNotFoundException {
        Client client = getClient(id);

        // System.currentTimeMillis = function who return today date
        Timestamp clientBirth = client.getBirthDate();

        final int majorityAge = 18;

        return getAge(clientBirth) >= 18;
    }

    public boolean hasReservationBetween(Timestamp start, Timestamp end) {
        return false;
    }

    public void createClient(Client client) {
        clientRepository.save(client);
    }

    public Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClient(int id) throws ClientIdNotFoundException {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return client.get();
        } else {
            throw new ClientIdNotFoundException("Client not found.");
        }
    }

    public Client deleteClient(int id) throws ClientIdNotFoundException {
        Client client = getClient(id);
        clientRepository.deleteById(id);
        return client;
    }

    public void modifyClient(int id, Client client) throws ClientIdNotFoundException {
        getClient(id);
        client.setId(id);
        createClient(client);
    }

}
