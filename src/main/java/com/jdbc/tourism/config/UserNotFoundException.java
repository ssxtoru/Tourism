package com.jdbc.tourism.config;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) { super(message);
    }
}
