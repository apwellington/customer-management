package com.example.customermanagement.exceptions;

/**
 * Created by Wellington Adames on 08/08/2021
 */
public class CustomerException extends Exception{
    public CustomerException(Exception e) {
        super(e);
    }

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException() {
    }
}
