package com.example.PlantCare.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ReminderNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFound(ReminderNotFoundException ex) {

        Map<String, Object> error = new HashMap<>();

        error.put("timestamp", LocalDateTime.now());
        error.put("status", HttpStatus.NOT_FOUND.value());
        error.put("error", "Reminder Not Found");
        error.put("message", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PlantNotFoundException.class)
    public ResponseEntity<?> plantNotFound(PlantNotFoundException ex){
        Map<String ,Object> error = new HashMap<>();
        error.put("timestamp" , LocalDate.now());
        error.put("status", HttpStatus.NOT_FOUND.value());
        error.put("error" , "Plant Not Found!!!");
        error.put("message",ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(ScheduleNotFoundException.class)
    public ResponseEntity<?> ScheduleNotFound(ScheduleNotFoundException ex){
        Map<String ,Object> error = new HashMap<>();
        error.put("timestamp" , LocalDate.now());
        error.put("status", HttpStatus.NOT_FOUND.value());
        error.put("error" , "Schedule Not Found!!!");
        error.put("message",ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(plantDeletionException.class)
    public ResponseEntity<?> handlePlantDeletionException(
            plantDeletionException ex) {

        Map<String, Object> error = new HashMap<>();

        error.put("timestamp", LocalDateTime.now());
        error.put("status", HttpStatus.BAD_REQUEST.value());
        error.put("error", "Plant Deletion Failed");
        error.put("message", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}