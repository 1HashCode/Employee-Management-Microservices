package com.em.performance_service.entity.status;

import com.em.performance_service.exception.InvalidEvaluationStatusException;

public enum EvaluationStatus {
    PENDING("Pending"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    APPROVED("Approved"),
    REJECTED("Rejected"),
    ARCHIVED("Archived");

    EvaluationStatus(String status) {
        this.status=status;
    }
    private final String status;

    public String getStatus() {
        return status;
    }

    public static EvaluationStatus fromString(String status){
        for(EvaluationStatus e:EvaluationStatus.values()){
            if(e.getStatus().equals(status)){
                return e;
            }
        }

        throw new InvalidEvaluationStatusException();
    }
}
