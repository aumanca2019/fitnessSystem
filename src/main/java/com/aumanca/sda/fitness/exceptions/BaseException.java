package com.aumanca.sda.fitness.exceptions;

public abstract class BaseException extends RuntimeException {

    protected String message;

    public abstract String getCode();

    public BaseException(String message) {
        super(message);
    }
}
