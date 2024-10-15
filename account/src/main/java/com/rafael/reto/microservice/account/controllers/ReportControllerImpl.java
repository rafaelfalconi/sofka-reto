package com.rafael.reto.microservice.account.controllers;

import com.rafael.reto.microservice.account.dtos.ReportDto;
import com.rafael.reto.microservice.account.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/reportes")
public class ReportControllerImpl implements ReportController {
    private final ReportService reportService;
    @Override
    @GetMapping
    public List<ReportDto> getReportsByClientAndDate(String fecha, int cliente) throws ParseException {
        return reportService.getReportsByClientAndDate(fecha,cliente);
    }
}
