package ru.naburnm8.bmstu.datamanagementnirbackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Clients;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.ClientsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @GetMapping
    public List<Clients> getAllClients() {
        return clientsService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clients> getClientById(@PathVariable int id) {
        Optional<Clients> clients = clientsService.getClientById(id);
        return clients.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Clients createClient(@RequestBody Clients client) {
        return clientsService.createClient(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clients> updateClient(@PathVariable int id, @RequestBody Clients client) {
        return ResponseEntity.ok(clientsService.updateClient(id, client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable int id) {
        clientsService.deleteClientById(id);
        return ResponseEntity.ok().build();
    }
}
