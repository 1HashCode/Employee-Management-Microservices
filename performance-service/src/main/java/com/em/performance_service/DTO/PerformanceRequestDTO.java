package com.em.performance_service.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PerformanceRequestDTO {

    @NotBlank(message = "Evaluation status cannot be blank")
    private String evaluationStatus;

    @NotBlank(message = "Review period start date cannot be blank")
    private String reviewPeriodStart;

    @NotBlank(message = "Review period end date cannot be blank")
    private String reviewPeriodEnd;

    @NotBlank(message = "Rating cannot be blank")
    private String rating;

    @Size(max=40,message="comments should be less than 40 characters")
    private String comments;

    @NotBlank(message = "Strengths cannot be blank")
    private String strengths;

    @NotBlank(message = "Areas for improvement cannot be blank")
    private String areasForImprovement;

    public PerformanceRequestDTO() {

    }

    public String getEvaluationStatus() {
        return evaluationStatus;
    }

    public void setEvaluationStatus(String evaluationStatus) {
        this.evaluationStatus = evaluationStatus;
    }

    public String getReviewPeriodEnd() {
        return reviewPeriodEnd;
    }

    public void setReviewPeriodEnd(String reviewPeriodEnd) {
        this.reviewPeriodEnd = reviewPeriodEnd;
    }

    public String getReviewPeriodStart() {
        return reviewPeriodStart;
    }

    public void setReviewPeriodStart(String reviewPeriodStart) {
        this.reviewPeriodStart = reviewPeriodStart;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
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
