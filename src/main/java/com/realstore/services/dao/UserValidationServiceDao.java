package com.realstore.services.dao;

public interface UserValidationServiceDao {

    boolean checkUserCredential(String userName, String userPassword);

    boolean checkUserName(String userName);

    boolean checkUserPassword(String userName, String userPassword);

    String getErrorMessage();
}
