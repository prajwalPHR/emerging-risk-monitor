package com.internship.tool.repository;

import com.internship.tool.entity.Risk;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiskRepository
        extends JpaRepository<Risk, Long> {

    Page<Risk> findByTitleContainingIgnoreCase(
            String keyword,
            Pageable pageable
    );

    List<Risk> findByStatus(String status);
}