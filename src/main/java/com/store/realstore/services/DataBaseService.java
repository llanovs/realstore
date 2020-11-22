package com.store.realstore.services;

import com.store.realstore.exceptions.RealStoreException;
import com.store.realstore.models.User;
import org.springframework.stereotype.Service;

@Service
public class DataBaseService {

    private static DataBaseService dataBaseService;

    private DataBaseService(){
    }

    public static DataBaseService getDataBaseService() {
        if(dataBaseService == null){
            dataBaseService = new DataBaseService();
        }
        return dataBaseService;
    }

    public boolean addUser(String userName, String userPassword) throws RealStoreException {
        //if something went wrong and the user didn't save thrown an exception
        boolean hasError = false;
        if(hasError){
            throw new RealStoreException(RealStoreException.UNKNOWN_EXCEPTION);
        }
        return true;
    }

    public void updateUserPassword(String userName, String oldUserPassword, String newUserPassword) throws RealStoreException {
        //if something went wrong and the user didn't save thrown an exception
        boolean hasError = false;
        if(hasError){
            throw new RealStoreException(RealStoreException.UNKNOWN_EXCEPTION);
        }
    }

    public User getUserInfo(String userName) throws RealStoreException {
        //if something went wrong and the user didn't save thrown an exception
        boolean hasError = false;
        if(hasError){
            throw new RealStoreException(RealStoreException.UNKNOWN_EXCEPTION);
        }
        return new User("Liliia","111");
    }

    public void updateUserInformation(String userName) throws RealStoreException {
        //if something went wrong and the user didn't save thrown an exception
        boolean hasError = false;
        if(hasError){
            throw new RealStoreException(RealStoreException.UNKNOWN_EXCEPTION);
        }
    }

    public boolean deleteUser(String userName, String userPassword) throws RealStoreException {
        //if something went wrong and the user didn't save thrown an exception
        if(userName.equals("A") || userPassword.equals("1")){
            throw new RealStoreException(RealStoreException.UNKNOWN_EXCEPTION);
        }
        return true;
    }

    public String getUserNameFromDb() {
        return "Liliia";
    }

    public String getUserPasswordFromDb(String userName) {
        return "111";
    }
}
