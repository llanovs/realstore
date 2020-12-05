package com.realstore.services;

import com.realstore.services.dao.DataBaseServiceDao;
import com.realstore.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mongo")
public class MongoDataBaseService implements DataBaseServiceDao {

    @Override
    public void createConnection() {
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(UUID userId) {
        return false;
    }

    @Override
    public boolean updateUserPassword(UUID userId, String newUserPassword) {
        return false;
    }

    @Override
    public boolean updateUserInformation(UUID userId, User user) {
        return false;
    }

    @Override
    public Optional<User> getUserById(UUID userId) {
        return null;
    }

    @Override
    public Optional<User> getUserByName(String userName) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

}
