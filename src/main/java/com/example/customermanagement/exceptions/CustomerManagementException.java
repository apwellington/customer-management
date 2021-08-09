package com.example.customermanagement.exceptions;

/**
 * Created by Wellington Adames on 08/08/2021
 */
public class CustomerManagementException extends Exception{
    public CustomerManagementException() {
    }

    public CustomerManagementException(String message) {
        super(message);
    }

    public CustomerManagementException(Throwable cause) {
        super(cause);
    }
}
