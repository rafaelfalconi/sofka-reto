package com.rafael.reto.microservice.account.controllers;

import com.rafael.reto.microservice.account.dtos.ReportDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

public interface ReportController {

    public List<ReportDto> getReportsByClientAndDate(@RequestParam String fecha,@RequestParam int cliente) throws ParseException;
}
