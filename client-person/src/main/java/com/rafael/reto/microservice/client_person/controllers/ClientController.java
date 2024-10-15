package com.rafael.reto.microservice.client_person.controllers;

import com.rafael.reto.microservice.client_person.dtos.ClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClientController {
    ResponseEntity<String> createClient(@RequestBody ClientDto client);
    ResponseEntity<String> deleteClient( @PathVariable String id);
    ResponseEntity<String> updateClient(@RequestBody ClientDto client, @PathVariable String id);
    ResponseEntity<String> editClients(@RequestBody ClientDto client, @PathVariable String id);
}
