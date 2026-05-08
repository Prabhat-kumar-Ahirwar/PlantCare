package com.example.PlantCare.ExceptionHandler;

public class ReminderNotFoundException extends RuntimeException {

    public ReminderNotFoundException(String message) {
        super(message);
    }
}