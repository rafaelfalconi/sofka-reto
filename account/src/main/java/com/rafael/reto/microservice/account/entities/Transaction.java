package com.rafael.reto.microservice.account.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name = "id_account")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "moven_date")
    private Date date;

    @Column(name = "type")
    private String type;

    @Column(name = "worth")
    private double worth;

    @Column(name = "balance")
    private double balance;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

}
