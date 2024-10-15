package com.rafael.reto.microservice.client_person.services;

import com.rafael.reto.microservice.client_person.dtos.ClientDto;
import com.rafael.reto.microservice.client_person.entities.Account;
import com.rafael.reto.microservice.client_person.entities.Client;
import com.rafael.reto.microservice.client_person.exceptions.IncorrectDataException;
import com.rafael.reto.microservice.client_person.exceptions.NotFoundException;
import com.rafael.reto.microservice.client_person.repositories.AccountRepository;
import com.rafael.reto.microservice.client_person.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;

    @Override
    public void createClient(ClientDto clientDto) {
        Optional<Client> clientBb = this.clientRepository.findById(clientDto.getId());
        if (clientBb.isPresent())
            throw new IncorrectDataException("El cliente ya existe");
        try {
            Client client = Client.builder()
                    .name(clientDto.getName())
                    .gender(clientDto.getGender())
                    .age(clientDto.getAge())
                    .address(clientDto.getAddress())
                    .phone(clientDto.getPhone())
                    .password(clientDto.getPassword())
                    .state(clientDto.getState())
                    .identification(clientDto.getIdentification())
                    .id(clientDto.getId())
                    .build();
            this.clientRepository.save(client);
        } catch (Exception e) {
            throw new IncorrectDataException("Datos incorrectos");
        }

    }

    @Override
    public void deleteClient(String clientId) {

        Optional<Client> client = this.clientRepository.findById(clientId);
        if (client.isEmpty()) throw new NotFoundException("el cliente no existe");
        List<Account> accounts = this.accountRepository.findAccountsByClient(client.get());
        if (!accounts.isEmpty())  throw new IncorrectDataException("el cliente tiene cuentas");;
        try {
            this.clientRepository.deleteById(clientId);
        } catch (Exception e) {
            throw new IncorrectDataException(e.getMessage());
        }

    }

    @Override
    public void updateClient(String clientId, ClientDto clientDto) {

        Optional<Client> clientdb = this.clientRepository.findById(clientId);
        if (clientdb.isEmpty())
            throw new NotFoundException("el cliente no existe");
        try {
            Client client = clientdb.get();
            if (clientDto.getName() != null) client.setName(clientDto.getName());
            if (clientDto.getGender() != null) client.setGender(clientDto.getGender());
            if (clientDto.getAge() != 0) client.setAge(clientDto.getAge());
            if (clientDto.getAddress() != null) client.setAddress(clientDto.getAddress());
            if (clientDto.getPhone() != null) client.setPhone(clientDto.getPhone());
            if (clientDto.getPassword() != null) client.setPassword(clientDto.getPassword());
            if (clientDto.getState() != null) client.setState(clientDto.getState());
            if (clientDto.getIdentification() != null) client.setIdentification(clientDto.getIdentification());
            this.clientRepository.save(client);
        } catch (Exception e) {
            throw new IncorrectDataException(e.getMessage());
        }
    }

    @Override
    public void editClient(String clientId, ClientDto clientDto) {

        Optional<Client> clientdb = this.clientRepository.findById(clientId);
        if (clientdb.isEmpty())
            throw new NotFoundException("el cliente no existe");
        try {
            Client client = clientdb.get();
            client.setName(clientDto.getName());
            client.setGender(clientDto.getGender());
            client.setAge(clientDto.getAge());
            client.setAddress(clientDto.getAddress());
            client.setPhone(clientDto.getPhone());
            client.setPassword(clientDto.getPassword());
            client.setState(clientDto.getState());
            client.setIdentification(clientDto.getIdentification());
            this.clientRepository.save(client);
        } catch (Exception e) {
            throw new IncorrectDataException(e.getMessage());
        }

    }
}
