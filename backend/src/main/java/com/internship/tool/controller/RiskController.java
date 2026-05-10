package com.internship.tool.controller;

import com.internship.tool.dto.RiskRequest;
import com.internship.tool.dto.RiskResponse;

import com.internship.tool.entity.Risk;

import com.internship.tool.repository.RiskRepository;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risks")
@CrossOrigin("*")

public class RiskController {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    RiskController.class
            );

    private final RiskRepository riskRepository;

    public RiskController(
            RiskRepository riskRepository
    ) {

        this.riskRepository = riskRepository;
    }

    @GetMapping
    public List<RiskResponse> getRisks(

            @RequestParam(
                    defaultValue = "0"
            )
            int page,

            @RequestParam(
                    defaultValue = "5"
            )
            int size,

            @RequestParam(
                    defaultValue = "id"
            )
            String sortBy
    ) {

        logger.info("Fetching all risks");

        Pageable pageable =
                PageRequest.of(
                        page,
                        size,
                        Sort.by(sortBy)
                );

        Page<Risk> risks =
                riskRepository.findAll(pageable);

        return risks.stream().map(risk -> {

            RiskResponse response =
                    new RiskResponse();

            response.id = risk.getId();

            response.title = risk.getTitle();

            response.status = risk.getStatus();

            return response;

        }).toList();
    }

    @PostMapping
    public Risk createRisk(

            @Valid
            @RequestBody
            RiskRequest request
    ) {

        logger.info(
                "Creating risk with title: {}",
                request.title
        );

        Risk risk = new Risk();

        risk.setTitle(request.title);

        risk.setStatus(request.status);

        return riskRepository.save(risk);
    }

    @GetMapping("/search")
    public List<RiskResponse> searchRisks(

            @RequestParam String keyword
    ) {

        Pageable pageable =
                PageRequest.of(0, 10);

        Page<Risk> risks =
                riskRepository
                        .findByTitleContainingIgnoreCase(
                                keyword,
                                pageable
                        );

        return risks.stream().map(risk -> {

            RiskResponse response =
                    new RiskResponse();

            response.id = risk.getId();

            response.title = risk.getTitle();

            response.status = risk.getStatus();

            return response;

        }).toList();
    }
}