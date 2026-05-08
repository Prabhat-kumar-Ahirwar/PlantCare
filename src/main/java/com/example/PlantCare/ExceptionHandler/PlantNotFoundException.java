package com.example.PlantCare.ExceptionHandler;

public class PlantNotFoundException extends RuntimeException{
    public PlantNotFoundException(String message) {
        super(message);
    }
}
