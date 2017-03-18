package com.phc.das.exceptions;

public class BaseException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final String message = "Exception occured";

    public BaseException() {
        super(message);
    }

    public BaseException(String message) {
        super(message);
    }
}
