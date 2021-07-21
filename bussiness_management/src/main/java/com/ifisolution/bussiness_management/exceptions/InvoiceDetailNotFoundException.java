package com.ifisolution.bussiness_management.exceptions;

public class InvoiceDetailNotFoundException extends RuntimeException {
    public InvoiceDetailNotFoundException(String message) {
        super(message);
    }
}
