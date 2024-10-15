package com.rafael.reto.microservice.client_person.services;

import com.rafael.reto.microservice.client_person.dtos.ClientDto;

public interface ClientService {
    public void createClient(ClientDto clientDto);

    public void deleteClient(String clientId);

    public void updateClient(String clientId, ClientDto clientDto);

    public void editClient(String clientId, ClientDto clientDto);
}
