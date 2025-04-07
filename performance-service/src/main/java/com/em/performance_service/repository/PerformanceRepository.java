package com.em.performance_service.repository;

import com.em.performance_service.entity.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PerformanceRepository extends JpaRepository<PerformanceReview, UUID> {

}
