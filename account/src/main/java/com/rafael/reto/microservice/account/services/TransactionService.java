package com.rafael.reto.microservice.account.services;

import com.rafael.reto.microservice.account.dtos.TransactionDto;
import com.rafael.reto.microservice.account.entities.Account;
import com.rafael.reto.microservice.account.entities.Transaction;

import java.util.List;

public interface TransactionService {
    void createTransaction(TransactionDto transactionDto);

    void deleteTransaction(int id);

    void updateTransaction(TransactionDto transactionDto, int id);

    void editTransaction(TransactionDto transactionDto, int id);

    void saveTransaction(TransactionDto transactionDto, Account account);

    List<Transaction> getAllTransactions(Account account);
}
