package com.rafael.reto.microservice.account.controllers;

import com.rafael.reto.microservice.account.dtos.TransactionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface TransactionController {
    ResponseEntity<String> createTransaction(@RequestBody TransactionDto transactionDto);

    ResponseEntity<String> deleteTransaction(@PathVariable int id);

    ResponseEntity<String> updateTransaction(@RequestBody TransactionDto transactionDto, @PathVariable int id);

    ResponseEntity<String> editTransaction(@RequestBody TransactionDto transactionDto, @PathVariable int id);
}
