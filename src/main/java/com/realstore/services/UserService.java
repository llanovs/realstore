package com.realstore.services;

import com.realstore.services.dao.DataBaseServiceDao;
import com.realstore.services.dao.UserServiceDao;
import com.realstore.models.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserServiceDao {

    private final DataBaseServiceDao dataBaseService;

    public UserService(@Qualifier("fakeDb") DataBaseServiceDao dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    @Override
    public boolean addUser(User user) {
        return dataBaseService.addUser(user);
    }

    @Override
    public boolean deleteUser(UUID userId) {
        return dataBaseService.deleteUser(userId);
    }

    @Override
    public Optional<User> getUserByName(String userName) {
        return dataBaseService.getUserByName(userName);
    }

    @Override
    public Optional<User> getUserByNameAndPassword(String userName, String userPassword) {
        return dataBaseService.getUserByName(userName);
    }


    @Override
    public List<User> getAllUsers() {
        return dataBaseService.getAllUsers();
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return dataBaseService.getUserById(id);
    }

    @Override
    public boolean updateUserPassword(UUID userId,User user) {
        return dataBaseService.updateUserPassword(userId, user.getPassword());
    }

    @Override
    public boolean updateUserInformation(UUID userId, User user) {
        return dataBaseService.updateUserInformation(userId, user);
    }
}
