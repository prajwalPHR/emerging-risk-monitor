package com.internship.tool.controller;

import com.internship.tool.entity.Risk;
import com.internship.tool.service.RiskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risks")
import jakarta.validation.Valid;
public class RiskController {

    private final RiskService service;

    public RiskController(RiskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Risk> getAll() {
        return service.getAllRisks();
    }
    @GetMapping
    public ApiResponse<List<Risk>> getAll() {

        List<Risk> risks = service.getAllRisks();

        return new ApiResponse<>(
                true,
                "Risks fetched successfully",
                risks
        );
    }
    @PostMapping
    public Risk createRisk(@Valid @RequestBody Risk risk) {
        return repository.save(risk);
    }

    @GetMapping("/status/{status}")
    public List<Risk> getByStatus(@PathVariable String status) {
        return service.getByStatus(status);
    }
}