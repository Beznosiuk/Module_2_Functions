package com.epam.engx.cleancode.functions.task3;

public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException(String errorMessage) {
        super(errorMessage);
    }
}
