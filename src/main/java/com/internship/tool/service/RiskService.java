package com.internship.tool.service;

import com.internship.tool.entity.Risk;
import com.internship.tool.repository.RiskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskService {

    private final RiskRepository repository;

    public RiskService(RiskRepository repository) {
        this.repository = repository;
    }

    public List<Risk> getAllRisks() {
        return repository.findAll();
    }

    public List<Risk> getByStatus(String status) {
        return repository.findByStatus(status);
    }

    // ✅ REQUIRED FOR SCHEDULER
    public void handleOverdueRisks() {
        System.out.println("Checking overdue risks...");
    }
}