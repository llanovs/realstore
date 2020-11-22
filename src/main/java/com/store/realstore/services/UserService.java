package com.store.realstore.services;

import com.store.realstore.exceptions.RealStoreException;
import com.store.realstore.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final ErrorHandlingService errorHandlingService;

    @Autowired
    private final DataBaseService dataBaseService;

    public UserService() {
        errorHandlingService = ErrorHandlingService.getErrorHandlingService();
        dataBaseService = DataBaseService.getDataBaseService();
    }

    // operation with user

    public boolean addUser(String userName, String userPassword) {
        if (userName != null && userPassword != null) {
            try {
                if (checkUserCredential(userName, userPassword)) {
                    throw new RealStoreException(RealStoreException.USER_EXIST);
                }
                if (!checkForEmptiness(userName) && !checkForEmptiness(userPassword)) {
                    dataBaseService.addUser(userName, userPassword);
                    return true;
                }
            } catch (RealStoreException e) {
                errorHandlingService.setMessage(e.getMessage());
            }
        }
        return false;
    }

    public boolean updateUserPassword(String userName, String oldUserPassword, String newUserPassword) {
        try {
            if (checkUserCredential(userName, oldUserPassword)) {
                dataBaseService.updateUserPassword(userName, oldUserPassword, newUserPassword);
            } else {
                throw new RealStoreException(RealStoreException.UNKNOWN_USER);
            }
        } catch (RealStoreException e) {
            errorHandlingService.setMessage(e.getMessage());
        }
        return true;
    }

    public boolean updateUserInformation(String userName) {
        try {
            if (checkUserName(userName)) {
                dataBaseService.updateUserInformation(userName);
            } else {
                throw new RealStoreException(RealStoreException.UNKNOWN_USER);
            }
        } catch (RealStoreException e) {
            errorHandlingService.setMessage(e.getMessage());
        }
        return true;
    }

    public boolean deleteUser(String userName, String userPassword) {
        try {
            if (checkUserCredential(userName, userPassword)) {
                dataBaseService.deleteUser(userName, userPassword);
            } else {
                throw new RealStoreException(RealStoreException.UNKNOWN_USER);
            }
        } catch (RealStoreException e) {
            errorHandlingService.setMessage(e.getMessage());
        }
        return true;
    }

    public User showUserInfo(String userName) {
        try {
            if (checkUserName(userName)) {
                return dataBaseService.getUserInfo(userName);
            } else {
                throw new RealStoreException(RealStoreException.UNKNOWN_USER);
            }
        } catch (RealStoreException e) {
            errorHandlingService.setMessage(e.getMessage());
        }
        return null;
    }


    //check user credential

    public boolean checkUserCredential(String userName, String userPassword) {
        try {
            return checkUserName(userName) && checkPassword(userName, userPassword);
        } catch (RealStoreException e) {
            errorHandlingService.setMessage(e.getMessage());
        }
        return false;
    }

    public boolean checkUserName(String userName) throws RealStoreException {
        checkForEmptiness(userName);
        if (!userName.equals(dataBaseService.getUserNameFromDb())) {
            throw new RealStoreException(RealStoreException.UNKNOWN_USER);
        }
        return true;
    }

    protected boolean checkPassword(String userName, String userPassword) throws RealStoreException {
        checkForEmptiness(userPassword);
        if (!userPassword.equals(dataBaseService.getUserPasswordFromDb(userName))) {
            throw new RealStoreException(RealStoreException.WRONG_PASSWORD);
        }
        return true;
    }

    protected boolean checkForEmptiness(String string) throws RealStoreException {
        if (string == null || string.isEmpty()) {
            throw new RealStoreException(RealStoreException.EMPTY_FIELD);
        }
        return true;
    }

    public String getErrorMessage() {
        return errorHandlingService.getMessage();
    }
}
