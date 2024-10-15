package com.rafael.reto.microservice.client_person.controllers;

import com.google.gson.Gson;
import com.rafael.reto.microservice.client_person.dtos.ClientDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations="classpath:test.properties")
class ClientControllerImplTest {
    private final ClientControllerImpl clientController;

    @Autowired
    public ClientControllerImplTest(ClientControllerImpl clientController) {
        this.clientController = clientController;
    }

    private ClientDto clientDto;

    @BeforeEach
    void setUp() {
        clientDto = ClientDto.builder()
                .id("1")
                .address("quito")
                .age(33)
                .name("Ramos")
                .gender("hombre")
                .password("123123")
                .phone("123123")
                .build();

    }

    @Test
    void createClient() {
        ResponseEntity<String> responseEntity = clientController.createClient(clientDto);
        System.out.println(responseEntity.getBody() + " " + responseEntity.getStatusCode());
    }
}