package com.rafael.reto.microservice.account.repositories;

import com.rafael.reto.microservice.account.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client, Integer> {
}
