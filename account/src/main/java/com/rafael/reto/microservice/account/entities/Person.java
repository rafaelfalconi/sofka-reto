package com.rafael.reto.microservice.account.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Person {

    @Id
    @Column(name = "id_client")
    private String id;
    private String name;
    private String gender;
    private int age;
    private String identification;
    private String address;
    private String phone;
}
