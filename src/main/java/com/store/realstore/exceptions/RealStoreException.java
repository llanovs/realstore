package com.store.realstore.exceptions;

public class RealStoreException extends Exception {
    public static final String UNKNOWN_USER = "UNKNOWN_USER";
    public static final String EMPTY_FIELD = "EMPTY_FIELD";
    public static final String WRONG_PASSWORD = "WRONG_PASSWORD";
    public static final String USER_EXIST = "USER_EXIST";
    public static final String UNKNOWN_EXCEPTION = "UNKNOWN_EXCEPTION";

    public RealStoreException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
