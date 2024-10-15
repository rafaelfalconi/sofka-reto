package com.rafael.reto.microservice.account.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client extends Person {

    @Column(name = "password")
    private String password;

    @Column(name = "state")
    private String state;

    @Builder
    public Client(String id, String name, String gender, int age, String identification, String address, String phone, String password, String state) {
        super(id, name, gender, age, identification, address, phone);
        this.password = password;
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(password, client.password) && Objects.equals(state, client.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), password, state);
    }
}
