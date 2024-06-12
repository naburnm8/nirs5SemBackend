package ru.naburnm8.bmstu.datamanagementnirbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Clients;
import ru.naburnm8.bmstu.datamanagementnirbackend.repositories.ClientsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }
    public Optional<Clients> getClientById(int id) {
        return clientsRepository.findById(id);
    }
    public Clients createClient(Clients client) {
        return clientsRepository.save(client);
    }
    public void deleteClientById(int id) {
        clientsRepository.deleteById(id);
    }
    public Clients updateClient(int id, Clients updatedClient) {
        return clientsRepository.findById(id).map(client -> {
            client.setFirstName(updatedClient.getFirstName());
            client.setLastName(updatedClient.getLastName());
            client.setPatronymic(updatedClient.getPatronymic());
            client.setPhone(updatedClient.getPhone());
            return clientsRepository.save(client);
        }).orElseGet(() -> {
            updatedClient.setId(id);
            return clientsRepository.save(updatedClient);
        });
    }
}
