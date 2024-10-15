package com.rafael.reto.microservice.client_person.repositories;

import com.rafael.reto.microservice.client_person.entities.Account;
import com.rafael.reto.microservice.client_person.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    public List<Account> findAccountsByClient(Client client);
}

