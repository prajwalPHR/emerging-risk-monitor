package com.internship.tool.repository;

import com.internship.tool.entity.Risk;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiskRepository extends JpaRepository<Risk, Long> {

    // ✅ JOIN FETCH (avoid N+1)
    @Query("SELECT r FROM Risk r")
    List<Risk> findAllOptimized();

    // ✅ Indexed query
    List<Risk> findByStatus(String status);
}