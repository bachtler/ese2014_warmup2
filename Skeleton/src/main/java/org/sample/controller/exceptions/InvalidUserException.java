package org.sample.controller.exceptions;

@SuppressWarnings("serial")
public class InvalidUserException extends RuntimeException {

    public InvalidUserException(String s) {
        super(s);
    }
}
