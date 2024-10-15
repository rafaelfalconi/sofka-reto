package com.rafael.reto.microservice.client_person.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientDto implements Serializable {

    private String name;
    private String gender;
    private int age;
    private String address;
    private String phone;
    private String id;
    private String password;
    private String state;
    private String identification;
}
