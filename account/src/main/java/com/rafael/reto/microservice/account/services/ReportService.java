package com.rafael.reto.microservice.account.services;

import com.rafael.reto.microservice.account.dtos.ReportDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

public interface ReportService {
    public List<ReportDto> getReportsByClientAndDate(String fecha, int cliente) throws ParseException;
}
