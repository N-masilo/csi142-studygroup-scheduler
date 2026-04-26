package ub.csi142.studygroupscheduler.exceptions;

//CUSTOM EXCEPTION — thrown when the user enters bad data.

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);

    }
    
}

