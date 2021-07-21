package com.ifisolution.bussiness_management.exceptions;

public class UsernameExistException extends RuntimeException {
    public UsernameExistException(String message) {
        super(message);
    }
}
