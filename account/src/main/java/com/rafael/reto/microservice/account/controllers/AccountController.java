package com.rafael.reto.microservice.account.controllers;

import com.rafael.reto.microservice.account.dtos.AccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface AccountController {
    ResponseEntity<String> createAccount(@RequestBody AccountDto accountDto);

    ResponseEntity<String> deleteAccount(@PathVariable int id);

    ResponseEntity<String> updateAccount(@RequestBody AccountDto accountDto, @PathVariable int id);

    ResponseEntity<String> editAccount(@RequestBody AccountDto accountDto, @PathVariable int id);
}
