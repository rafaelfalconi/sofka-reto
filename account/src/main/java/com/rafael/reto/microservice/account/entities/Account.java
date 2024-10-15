package com.rafael.reto.microservice.account.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "id_account")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "number")
    private int number;

    @Column(name = "type")
    private String type;

    @Column(name = "balance")
    private double balance;

    @Column(name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
}
