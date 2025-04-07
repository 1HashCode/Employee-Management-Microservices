package com.em.performance_service.exception;

public class InvalidEvaluationStatusException extends RuntimeException {
    public InvalidEvaluationStatusException() {
        super("Invalid evaluation status");
    }
}
