package com.realstore.services;

public class ErrorHandlingService {

    private static ErrorHandlingService errorHandlingService;
    private String message;

    public static ErrorHandlingService getErrorHandlingService() {
        if(errorHandlingService == null){
            errorHandlingService = new ErrorHandlingService();
        }
        return errorHandlingService;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
