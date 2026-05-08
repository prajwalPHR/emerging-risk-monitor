package com.internship.tool.controller;

import com.internship.tool.entity.Risk;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RiskController {

    @GetMapping("/api/risks")
    public List<Risk> getRisks() {

        Risk risk = new Risk();

        risk.setId(1L);
        risk.setTitle("Cyber Attack");
        risk.setStatus("HIGH");

        return List.of(risk);
    }
}