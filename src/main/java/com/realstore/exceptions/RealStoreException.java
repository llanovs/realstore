package com.realstore.exceptions;

public class RealStoreException extends Exception{

    //users exceptions
    public static final String UNKNOWN_USER = "UNKNOWN_USER";
    public static final String EMPTY_FIELD = "EMPTY_FIELD";
    public static final String WRONG_PASSWORD = "WRONG_PASSWORD";
    public static final String USER_EXIST = "USER_EXIST";
    public static final String UNKNOWN_EXCEPTION = "UNKNOWN_EXCEPTION";

    //Database exceptions
    public static final String CONNECTION_FAIL = "CONNECTION_FAIL";
    public static final String USER_DOES_NOT_FIND = "USER_DOES_NOT_FIND";

    public RealStoreException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
