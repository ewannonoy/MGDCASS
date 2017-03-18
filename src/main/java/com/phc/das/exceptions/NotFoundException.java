package com.phc.das.exceptions;

public class NotFoundException extends BaseException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final String message = "Entry not found";

    public NotFoundException() {
        super(message);
    }
}
