package com.example.customermanagement.exceptions;

/**
 * Created by Wellington Adames on 08/08/2021
 */
public class AddressException extends Exception{

    public AddressException() {
    }

    public AddressException(String message) {
        super(message);
    }

    public AddressException(Throwable cause) {
        super(cause);
    }
}
