package com.rafael.reto.microservice.client_person.repositories;

import com.rafael.reto.microservice.client_person.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
