package com.rafael.reto.microservice.account.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportDto {
    private String date;
    private String client;
    @JsonProperty("Account Number")
    private String accountNumber;
    private String type;
    @JsonProperty("Initial Balance")
    private double initialBalance;
    private String status;
    @JsonProperty("type of Transaction")
    private String typeOfMovement;
    private double worth;
    @JsonProperty("Final Balance")
    private double endBalance;
}
