package com.rafael.reto.microservice.account.repositories;

import com.rafael.reto.microservice.account.entities.Account;
import com.rafael.reto.microservice.account.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findTransactionsByAccountAndDateBetween(Account account, Date from, Date to);
    List<Transaction> findTransactionsByAccount(Account account);
}
