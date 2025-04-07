package com.em.performance_service.DTO;

public class PerformanceResponseDTO {
    private String id;
    private String evaluationStatus;
    private String reviewPeriodStart;
    private String reviewPeriodEnd;
    private String rating;
    private String comments;
    private String strengths;
    private String areasForImprovement;

    public PerformanceResponseDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvaluationStatus() {
        return evaluationStatus;
    }

    public void setEvaluationStatus(String evaluationStatus) {
        this.evaluationStatus = evaluationStatus;
    }

    public String getReviewPeriodStart() {
        return reviewPeriodStart;
    }

    public void setReviewPeriodStart(String reviewPeriodStart) {
        this.reviewPeriodStart = reviewPeriodStart;
    }

    public String getReviewPeriodEnd() {
        return reviewPeriodEnd;
    }

    public void setReviewPeriodEnd(String reviewPeriodEnd) {
        this.reviewPeriodEnd = reviewPeriodEnd;
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
