package com.rafael.reto.microservice.account.controllers;

import com.rafael.reto.microservice.account.dtos.TransactionDto;
import com.rafael.reto.microservice.account.services.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/movimientos")
public class TransactionControllerImpl implements TransactionController {
    private final TransactionService transactionService;

    @Override
    @PostMapping
    public ResponseEntity<String> createTransaction(@Valid @RequestBody TransactionDto transactionDto) {
        this.transactionService.createTransaction(transactionDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"transacción creada\"");
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable int id) {
        this.transactionService.deleteTransaction(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"transacción eliminada\"");
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateTransaction(@Valid @RequestBody TransactionDto transactionDto, @PathVariable int id) {
        this.transactionService.updateTransaction(transactionDto, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"transacción actualizada\"");
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<String> editTransaction(@Valid  @RequestBody TransactionDto transactionDto, @PathVariable int id) {
        this.transactionService.editTransaction(transactionDto, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"transacción editada\"");
    }
}
