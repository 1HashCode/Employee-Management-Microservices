package com.em.performance_service.service;

import com.em.performance_service.DTO.PerformanceRequestDTO;
import com.em.performance_service.DTO.PerformanceResponseDTO;
import com.em.performance_service.entity.PerformanceReview;
import com.em.performance_service.entity.status.EvaluationStatus;
import com.em.performance_service.exception.PerformanceAccountDoesntExist;
import com.em.performance_service.mapper.PerformanceMapper;
import com.em.performance_service.repository.PerformanceRepository;
import org.springframework.stereotype.Service;
import performance.PerformanceRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PerformanceService {

    private final PerformanceRepository performanceRepository;

    public PerformanceService(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }

    public void createPerformanceReview(PerformanceRequest performanceRequest) {
        PerformanceReview performanceReview = new PerformanceReview(UUID.fromString(performanceRequest.getEmployeeId()), EvaluationStatus.PENDING, LocalDate.now(),LocalDate.now().plusMonths(6), 0.0F, "", "strengths", "areasForImprovement");
        performanceRepository.save(performanceReview);
    }

    public PerformanceResponseDTO getPerformanceReviewById(UUID id) {
        PerformanceReview performanceReview= performanceRepository.findById(id).orElseThrow(PerformanceAccountDoesntExist::new);
        return PerformanceMapper.performanceReviewToDTO(performanceReview);
    }

    public List<PerformanceResponseDTO> getAllPerformanceReviews() {
        List<PerformanceReview> performanceReviews = performanceRepository.findAll();
        return performanceReviews.stream().map(PerformanceMapper::performanceReviewToDTO).toList();
    }

    public PerformanceResponseDTO updatePerformanceReview(UUID id, PerformanceRequestDTO performanceRequest) {
        PerformanceReview performanceReview = performanceRepository.findById(id).orElseThrow(PerformanceAccountDoesntExist::new);

        performanceReview.setEvaluationStatus(EvaluationStatus.fromString(performanceRequest.getEvaluationStatus()));
        performanceReview.setReviewPeriodStart(LocalDate.parse(performanceRequest.getReviewPeriodStart()));
        performanceReview.setReviewPeriodEnd(LocalDate.parse(performanceRequest.getReviewPeriodEnd()));
        performanceReview.setRating(Float.parseFloat(performanceRequest.getRating()));
        performanceReview.setComments(performanceRequest.getComments());
        performanceReview.setStrengths(performanceRequest.getStrengths());
        performanceReview.setAreasForImprovement(performanceRequest.getAreasForImprovement());

        PerformanceReview performanceReviewUpdated=performanceRepository.save(performanceReview);
        return PerformanceMapper.performanceReviewToDTO(performanceReviewUpdated);
    }

    public void deletePerformanceReview(UUID id) {
        performanceRepository.deleteById(id);
    }


}
