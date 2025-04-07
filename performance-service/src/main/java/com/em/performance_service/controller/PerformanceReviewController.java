package com.em.performance_service.controller;

import com.em.performance_service.DTO.PerformanceRequestDTO;
import com.em.performance_service.DTO.PerformanceResponseDTO;
import com.em.performance_service.service.PerformanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name="Performance Review", description = "Performance Review Management API")
@RequestMapping("/performanceReviews")
public class PerformanceReviewController {

    private final PerformanceService performanceReviewService;

    public PerformanceReviewController(PerformanceService performanceReviewService) {
        this.performanceReviewService = performanceReviewService;
    }

    @Operation(summary = "Get all performance reviews")
    @GetMapping
    public ResponseEntity<List<PerformanceResponseDTO>> getPerformanceReviews(){
        return ResponseEntity.ok(performanceReviewService.getAllPerformanceReviews());
    }

    @Operation(summary = "Get performance review by employee ID")
    @GetMapping("/{employeeId}")
    public ResponseEntity<PerformanceResponseDTO> getPerformanceReviewById(@PathVariable String employeeId){
        return ResponseEntity.ok(performanceReviewService.getPerformanceReviewById(UUID.fromString(employeeId)));
    }

    @Operation(summary = "Update a performance review")
    @PutMapping("/{employeeId}")
    public ResponseEntity<PerformanceResponseDTO> updatePerformanceReview(@PathVariable String employeeId, @Valid @RequestBody PerformanceRequestDTO performanceRequestDTO){
        return ResponseEntity.ok(performanceReviewService.updatePerformanceReview(UUID.fromString(employeeId), performanceRequestDTO));
    }

}
