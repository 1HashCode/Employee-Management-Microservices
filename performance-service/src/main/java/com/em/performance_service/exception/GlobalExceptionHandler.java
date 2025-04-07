package com.em.performance_service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> invalidMethodArgumentException(MethodArgumentNotValidException e){
        Map<String,String>map=new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error->map.put(error.getField(),error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(InvalidEvaluationStatusException.class)
    public ResponseEntity<Map<String,String>> handleInvalidEvaluationStatusException(InvalidEvaluationStatusException e){
        Map<String,String>map=new HashMap<>();
        map.put("message","Invalid Evaluation Status");
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(PerformanceAccountDoesntExist.class)
    public ResponseEntity<Map<String,String>> handlePerformanceAccountDoesntExist(PerformanceAccountDoesntExist e){
        Map<String,String>map=new HashMap<>();
        map.put("message","Performance account does not exist");
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<Map<String,String>> handleDateTimeParseException(DateTimeParseException e){
        Map<String,String>map=new HashMap<>();
        map.put("message","Invalid date format");
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Map<String,String>> handleNumberFormatException(NumberFormatException e){
        Map<String,String>map=new HashMap<>();
        map.put("message","Invalid number format");
        return ResponseEntity.badRequest().body(map);
    }
}
