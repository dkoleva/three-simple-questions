package com.three.simple.questions.backend.service;

public class ProfileNotFoundException extends RuntimeException {
    private String message;

    public ProfileNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

