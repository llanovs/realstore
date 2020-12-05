package com.realstore.services;

import com.realstore.services.dao.DataBaseServiceDao;
import com.realstore.models.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDb")
public class FakeDBService implements DataBaseServiceDao {

    private final ErrorHandlingService errorHandlingService;
    private List<User> userList;

    public FakeDBService() {
        createConnection();
        errorHandlingService = ErrorHandlingService.getErrorHandlingService();
    }

    @Override
    public void createConnection() {
        userList = new ArrayList<>();
    }

    @Override
    public boolean addUser(User user) {
        return userList.add(user);
    }

    @Override
    public boolean deleteUser(UUID userId) {
        Optional<User> currentUser = getUserById(userId);
        if(currentUser.isPresent()) {
            userList.remove(currentUser.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserPassword(UUID userId, String newUserPassword) {
        Optional<User> currentUser = getUserById(userId);
        if(currentUser.isPresent()) {
            currentUser.get().setPassword(newUserPassword);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserInformation(UUID userId, User user) {
        Optional<User> currentUser = getUserById(userId);
        if(currentUser.isPresent()) {
            currentUser.get().setPassword(user.getPassword());
            currentUser.get().setName(user.getName());
            return true;
        }
        return false;
    }

    @Override
    public Optional<User> getUserById(UUID userId) {
        return userList.stream().filter(user -> userId.equals(user.getId())).findFirst();
    }

    @Override
    public Optional<User> getUserByName(String userName) {
        return userList.stream().filter(user -> userName.equals(user.getName())).findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }
}
