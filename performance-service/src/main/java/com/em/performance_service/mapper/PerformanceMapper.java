package com.em.performance_service.mapper;

import com.em.performance_service.DTO.PerformanceResponseDTO;
import com.em.performance_service.entity.PerformanceReview;

public class PerformanceMapper {
    public static PerformanceResponseDTO performanceReviewToDTO(PerformanceReview performanceReview){
        PerformanceResponseDTO performanceResponseDTO = new PerformanceResponseDTO();

        performanceResponseDTO.setId(performanceReview.getId().toString());
        performanceResponseDTO.setAreasForImprovement(performanceReview.getAreasForImprovement());
        performanceResponseDTO.setComments(performanceReview.getComments());
        performanceResponseDTO.setEvaluationStatus(performanceReview.getEvaluationStatus().getStatus());
        performanceResponseDTO.setRating(performanceReview.getRating().toString());
        performanceResponseDTO.setReviewPeriodEnd(performanceReview.getReviewPeriodEnd().toString());
        performanceResponseDTO.setReviewPeriodStart(performanceReview.getReviewPeriodStart().toString());
        performanceResponseDTO.setStrengths(performanceReview.getStrengths());

        return performanceResponseDTO;
    }

}
