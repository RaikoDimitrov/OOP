package com.company.ExceptionsAndErrorHandling.validPerson;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException() {
        this("Person name cannot contain numbers or special symbols.");
    }

}
