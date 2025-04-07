package com.em.performance_service.exception;

public class PerformanceAccountDoesntExist extends RuntimeException {
    public PerformanceAccountDoesntExist() {
        super("Performance account does not exist");
    }
}
