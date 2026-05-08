package com.example.PlantCare.ExceptionHandler;

public class ScheduleNotFoundException extends RuntimeException{
    public ScheduleNotFoundException(String message) {
        super(message);
    }
}
