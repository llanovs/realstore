package com.realstore.services;

import com.realstore.services.dao.UserValidationServiceDao;

public class UserValidationService implements UserValidationServiceDao {

    @Override
    public boolean checkUserCredential(String userName, String userPassword) {
        return false;
    }

    @Override
    public boolean checkUserName(String userName) {
        return false;
    }

    @Override
    public boolean checkUserPassword(String userName, String userPassword) {
        return false;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
