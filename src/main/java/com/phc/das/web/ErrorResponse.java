package com.phc.das.web;

import lombok.Data;

@Data
public class ErrorResponse {

    private String message = "Server error occurred. Please contact administrator";
    private String errorCode = "50000";

    public ErrorResponse() {}

    public ErrorResponse(String message) {
        this.message = message;
    }

    public ErrorResponse(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
