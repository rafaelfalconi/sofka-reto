package com.rafael.reto.microservice.account.controllers;

import com.rafael.reto.microservice.account.dtos.AccountDto;
import com.rafael.reto.microservice.account.services.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cuentas")
public class AccountControllerImpl implements AccountController {
    private final AccountService accountService;

    @Override
    @PostMapping
    public ResponseEntity<String> createAccount(@Valid AccountDto accountDto) {
        this.accountService.createAccount(accountDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"cuenta creada\"");
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable int id) {
        this.accountService.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"cuenta eliminada\"");
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateAccount(@Valid @RequestBody AccountDto accountDto, @PathVariable int id) {
        this.accountService.updateAccount(accountDto, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"cuenta actualizada\"");
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<String> editAccount(@Valid @RequestBody AccountDto accountDto, @PathVariable int id) {
        this.accountService.editAccount(accountDto, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"cuenta editada\"");
    }
}
