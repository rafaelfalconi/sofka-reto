package com.rafael.reto.microservice.account.services;

import com.rafael.reto.microservice.account.dtos.TransactionDto;
import com.rafael.reto.microservice.account.dtos.TransactionType;
import com.rafael.reto.microservice.account.entities.Account;
import com.rafael.reto.microservice.account.entities.Transaction;
import com.rafael.reto.microservice.account.exceptions.IncorrectDataException;
import com.rafael.reto.microservice.account.exceptions.NotFoundException;
import com.rafael.reto.microservice.account.repositories.AccountRepository;
import com.rafael.reto.microservice.account.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Override
    public void createTransaction(TransactionDto transactionDto) {
        Optional<Account> accountDb = this.accountRepository.findById(transactionDto.getAccountNumber());
        if (accountDb.isEmpty()) throw new NotFoundException("\"La cuenta no existe \"");
        Account account = accountDb.get();
        if (!validateFunds(account.getBalance(), transactionDto.getWorth()))
            throw new NotFoundException("\"fondos insuficientes \"");
        this.saveTransaction(transactionDto, account);
    }

    @Override
    public void deleteTransaction(int id) {
        Optional<Transaction> transactionDb = this.transactionRepository.findById(id);
        if (transactionDb.isEmpty()) throw new NotFoundException("\"La transacción no existe \"");
        try {
            this.transactionRepository.deleteById(id);
        } catch (Exception e) {
            throw new IncorrectDataException("datos incorrectos");
        }
    }

    @Override
    public void updateTransaction(TransactionDto transactionDto, int id) {
        Optional<Transaction> transactionDb = this.transactionRepository.findById(id);
        if (transactionDb.isEmpty()) throw new NotFoundException("\"La transacción no existe \"");
        Transaction transaction = transactionDb.get();
        if (transactionDto.getAccountNumber() != 0) {
            Optional<Account> accountDb = this.accountRepository.findById(transactionDto.getAccountNumber());
            if (accountDb.isEmpty()) throw new NotFoundException("\"La cuenta no existe \"");
            transaction.setAccount(accountDb.get());
        }
        try {
            if (transactionDto.getDate() != null) transaction.setDate(stringToDate(transactionDto.getDate()));
            if (transactionDto.getWorth() != 0) transaction.setWorth(transactionDto.getWorth());
            if (transactionDto.getBalance() != 0) transaction.setBalance(transactionDto.getBalance());
            if (transactionDto.getType() != null) transaction.setType(transactionDto.getType().toString());
            this.transactionRepository.save(transaction);

        } catch (Exception e) {
            throw new IncorrectDataException("datos incorrectos");
        }
    }

    @Override
    public void editTransaction(TransactionDto transactionDto, int id) {
        Optional<Transaction> transactionDb = this.transactionRepository.findById(id);
        if (transactionDb.isEmpty()) throw new NotFoundException("\"La transacción no existe \"");
        Transaction transaction = transactionDb.get();
        Optional<Account> accountDb = this.accountRepository.findById(transactionDto.getAccountNumber());
        if (accountDb.isEmpty()) throw new NotFoundException("\"La cuenta no existe \"");
        transaction.setAccount(accountDb.get());
        try {
            transaction.setDate(stringToDate(transactionDto.getDate()));
            transaction.setWorth(transactionDto.getWorth());
            transaction.setBalance(transactionDto.getBalance());
            transaction.setType(transactionDto.getType().toString());
            this.transactionRepository.save(transaction);

        } catch (Exception e) {
            throw new IncorrectDataException("datos incorrectos");
        }
    }

    private boolean validateFunds(double accountBalance, double transactionWorth) {
        return !(accountBalance < (transactionWorth) * -1) || !(transactionWorth < 0);
    }

    private Date stringToDate(String date) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse(date, formatter);
        return new SimpleDateFormat("yyyy-MM-dd").parse(date1.toString());
    }

    @Override
    public void saveTransaction(TransactionDto transactionDto, Account account) {
        try {
            Calendar today = Calendar.getInstance();
            if (transactionDto.getType() == TransactionType.retiro)
                transactionDto.setWorth(transactionDto.getWorth() * -1);
            account.setBalance(account.getBalance() + transactionDto.getWorth());
            Transaction transaction = Transaction.builder()
                    .account(account)
                    .date(today.getTime())
                    .worth(transactionDto.getWorth())
                    .balance(account.getBalance())
                    .type(transactionDto.getType().toString())
                    .build();
            this.accountRepository.save(account);
            this.transactionRepository.save(transaction);
        } catch (Exception e) {
            throw new IncorrectDataException(e.getMessage());
        }
    }

    @Override
    public List<Transaction> getAllTransactions(Account account) {
        return this.transactionRepository.findTransactionsByAccount(account);
    }
}
