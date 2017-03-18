package com.phc.das.exceptions;

public class UsernameAlreadyExist extends BaseException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final String message = "Username already exist";

    public UsernameAlreadyExist() {
        super(message);
    }
}
