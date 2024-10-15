package com.rafael.reto.microservice.client_person.services;

import com.rafael.reto.microservice.client_person.dtos.ClientDto;
import com.rafael.reto.microservice.client_person.entities.Client;
import com.rafael.reto.microservice.client_person.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientServiceImpl;

    private ClientDto clientDto;

    private Client client;

    @BeforeEach
    public void setUp() {
        clientDto = ClientDto.builder()
                .name("name")
                .gender("Male")
                .age(20)
                .address("address")
                .phone("phone")
                .id("clientId")
                .password("password")
                .state("state")
                .identification("identification")
                .build();
        client = Client.builder()
                .name("name")
                .gender("Male")
                .age(20)
                .address("address")
                .phone("phone")
                .id("clientId")
                .password("password")
                .state("state")
                .identification("identification")
                .build();
    }

    @DisplayName("test for create test")
    @Test
    public void testCreateClient() {
        given(clientRepository.save(client)).willReturn(client);
        assertThat(client.getName()).isEqualTo("name");

    }
}
