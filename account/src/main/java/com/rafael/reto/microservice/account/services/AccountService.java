package com.rafael.reto.microservice.account.services;

import com.rafael.reto.microservice.account.dtos.AccountDto;

public interface AccountService {
    public void createAccount(AccountDto accountDto);
    public void deleteAccount(int id);
    public void updateAccount(AccountDto accountDto, int id);
    public void editAccount(AccountDto accountDto, int id);
}
