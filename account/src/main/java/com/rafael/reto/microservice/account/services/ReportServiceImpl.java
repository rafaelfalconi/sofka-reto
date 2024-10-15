package com.rafael.reto.microservice.account.services;

import com.rafael.reto.microservice.account.dtos.ReportDto;
import com.rafael.reto.microservice.account.entities.Account;
import com.rafael.reto.microservice.account.entities.Client;
import com.rafael.reto.microservice.account.entities.Transaction;
import com.rafael.reto.microservice.account.exceptions.NotFoundException;
import com.rafael.reto.microservice.account.repositories.AccountRepository;
import com.rafael.reto.microservice.account.repositories.ClientRepository;
import com.rafael.reto.microservice.account.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    @Override
    public List<ReportDto> getReportsByClientAndDate(String fecha, int cliente) throws ParseException {
        List<ReportDto> reports = new ArrayList<>();
        List<Date> dates = this.getDates(fecha);
        Optional<Client> clientDb = this.clientRepository.findById(cliente);
        if (clientDb.isEmpty()) throw new NotFoundException("\"el cliente no existe\"");
        List<Account> accounts = this.accountRepository.findAccountsByClient(clientDb.get());
        if (accounts.isEmpty()) throw new NotFoundException("\"el cliente no tiene cuentas \"");
        accounts.forEach(account -> {
            List<Transaction> transactions = this.transactionRepository.findTransactionsByAccountAndDateBetween(account,dates.get(0),dates.get(1));
            transactions.forEach(transaction -> {
                ReportDto reportDto = ReportDto.builder()
                        .date(transaction.getDate().toString())
                        .client(transaction.getAccount().getClient().getName())
                        .type(transaction.getAccount().getType())
                        .initialBalance(transaction.getBalance() - transaction.getWorth())
                        .status(transaction.getAccount().getState())
                        .worth(transaction.getWorth())
                        .typeOfMovement(transaction.getType())
                        .accountNumber(String.valueOf(account.getId()))
                        .endBalance(transaction.getBalance())
                        .build();
                reports.add(reportDto);
            });
        });


        return reports;

    }

    private List<Date> getDates(String fecha) throws ParseException {
        List<Date> dates = new ArrayList<>();
        String[] dateInString = fecha.split("-", 2);
        for (String dateSplit : dateInString) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(dateSplit);
            dates.add(date);
        }
        return dates;
    }
}
