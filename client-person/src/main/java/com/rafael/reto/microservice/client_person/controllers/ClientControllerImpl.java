package com.rafael.reto.microservice.client_person.controllers;

import com.rafael.reto.microservice.client_person.dtos.ClientDto;
import com.rafael.reto.microservice.client_person.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/clientes")
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;

    @Override
    @PostMapping
    public ResponseEntity<String> createClient(@RequestBody ClientDto client) {
        this.clientService.createClient(client);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"cliente creado\"");
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable String id) {
        this.clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"cliente eliminado\"");
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateClient(@RequestBody ClientDto client, @PathVariable String id) {
        this.clientService.updateClient(id, client);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"cliente actualizado\"");
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<String> editClients(@RequestBody ClientDto client, @PathVariable String id) {
        this.clientService.editClient(id, client);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"cliente editado\"");
    }
}
