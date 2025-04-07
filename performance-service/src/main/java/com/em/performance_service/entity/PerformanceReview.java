package com.em.performance_service.entity;

import com.em.performance_service.entity.status.EvaluationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;


@Entity
public class PerformanceReview {

    @Id
    private UUID id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EvaluationStatus evaluationStatus;

    @NotNull
    private LocalDate reviewPeriodStart;

    @NotNull
    private LocalDate reviewPeriodEnd;

    @NotNull
    private Float rating;

    private String comments;

    @NotNull
    private String strengths;

    @NotNull
    private String areasForImprovement;

    public PerformanceReview(UUID id, EvaluationStatus evaluationStatus, LocalDate reviewPeriodStart, LocalDate reviewPeriodEnd, Float rating, String comments, String strengths, String areasForImprovement) {
        this.id = id;
        this.evaluationStatus = evaluationStatus;
        this.reviewPeriodStart = reviewPeriodStart;
        this.reviewPeriodEnd = reviewPeriodEnd;
        this.rating = rating;
        this.comments = comments;
        this.strengths = strengths;
        this.areasForImprovement = areasForImprovement;
    }

    public PerformanceReview() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public EvaluationStatus getEvaluationStatus() {
        return evaluationStatus;
    }

    public void setEvaluationStatus(EvaluationStatus evaluationStatus) {
        this.evaluationStatus = evaluationStatus;
    }

    public LocalDate getReviewPeriodStart() {
        return reviewPeriodStart;
    }

    public void setReviewPeriodStart(LocalDate reviewPeriodStart) {
        this.reviewPeriodStart = reviewPeriodStart;
    }

    public LocalDate getReviewPeriodEnd() {
        return reviewPeriodEnd;
    }

    public void setReviewPeriodEnd(LocalDate reviewPeriodEnd) {
        this.reviewPeriodEnd = reviewPeriodEnd;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStrengths() {
        return strengths;
    }

    public void setStrengths(String strengths) {
        this.strengths = strengths;
    }

    public String getAreasForImprovement() {
        return areasForImprovement;
    }

    public void setAreasForImprovement(String areasForImprovement) {
        this.areasForImprovement = areasForImprovement;
    }
}
