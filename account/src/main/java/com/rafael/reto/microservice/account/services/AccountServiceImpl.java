package com.rafael.reto.microservice.account.services;

import com.rafael.reto.microservice.account.dtos.AccountDto;
import com.rafael.reto.microservice.account.dtos.TransactionDto;
import com.rafael.reto.microservice.account.dtos.TransactionType;
import com.rafael.reto.microservice.account.entities.Account;
import com.rafael.reto.microservice.account.entities.Client;
import com.rafael.reto.microservice.account.entities.Transaction;
import com.rafael.reto.microservice.account.exceptions.IncorrectDataException;
import com.rafael.reto.microservice.account.exceptions.NotFoundException;
import com.rafael.reto.microservice.account.repositories.AccountRepository;
import com.rafael.reto.microservice.account.repositories.ClientRepository;
import com.rafael.reto.microservice.account.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;
    private final TransactionService transactionService;

    @Override
    public void createAccount(AccountDto accountDto) {
        Optional<Client> client = clientRepository.findById(accountDto.getClientId());
        if (client.isEmpty()) throw new NotFoundException("\"el cliente no existe \"");
        try {
            Account account = Account.builder()
                    .number(accountDto.getNumber())
                    .type(accountDto.getType().toString())
                    .balance(0.0)
                    .state(accountDto.getState())
                    .client(client.get())
                    .build();
            Account accountDb = this.accountRepository.saveAndFlush(account);
            TransactionDto transaction = TransactionDto.builder()
                    .worth(accountDto.getBalance())
                    .type(TransactionType.deposito).build();
            this.transactionService.saveTransaction(transaction, accountDb);

        } catch (Exception e) {
            throw new IncorrectDataException("datos incorrectos");
        }
    }

    @Override
    public void deleteAccount(int id) {
        Optional<Account> accountDb = this.accountRepository.findById(id);
        if (accountDb.isEmpty()) throw new NotFoundException("\"la cuenta no existe\"");
        List<Transaction> transactions = this.transactionService.getAllTransactions(accountDb.get());
        if (!transactions.isEmpty()) throw new IncorrectDataException("la cuenta tiene transacciones");
        try {
            this.accountRepository.deleteById(id);
        } catch (Exception e) {
            throw new IncorrectDataException("existe movientos asociados a esta cuenta");
        }
    }

    @Override
    public void updateAccount(AccountDto accountDto, int id) {
        Optional<Account> accountDb = this.accountRepository.findById(id);
        if (accountDb.isEmpty()) throw new NotFoundException("\"la cuenta no existe\"");
        Account account = accountDb.get();
        if (accountDto.getClientId() != 0) {
            Optional<Client> clientDb = this.clientRepository.findById(accountDto.getClientId());
            if (clientDb.isEmpty()) throw new NotFoundException("\"el cliente no existe \"");
            account.setClient(clientDb.get());
        }
        try {
            if (accountDto.getNumber() != 0) account.setNumber(accountDto.getNumber());
            if (accountDto.getType() != null) account.setType(accountDto.getType().toString());
            if (accountDto.getBalance() != 0) account.setBalance(accountDto.getBalance());
            if (accountDto.getState() != null) account.setState(accountDto.getState());
            this.accountRepository.save(account);
        } catch (Exception e) {
            throw new IncorrectDataException("datos incorrectos");
        }
    }

    @Override
    public void editAccount(AccountDto accountDto, int id) {
        Optional<Account> accountDb = this.accountRepository.findById(id);
        if (accountDb.isEmpty()) throw new NotFoundException("\"la cuenta no existe\"");
        Optional<Client> clientDb = this.clientRepository.findById(accountDto.getClientId());
        if (clientDb.isEmpty()) throw new NotFoundException("\"el cliente no existe \"");
        try {
            Account account = accountDb.get();
            account.setClient(clientDb.get());
            account.setNumber(accountDto.getNumber());
            account.setType(accountDto.getType().toString());
            account.setBalance(accountDto.getBalance());
            account.setState(accountDto.getState());
            this.accountRepository.save(account);
        } catch (Exception e) {
            throw new IncorrectDataException("datos incorrectos");
        }
    }


}
