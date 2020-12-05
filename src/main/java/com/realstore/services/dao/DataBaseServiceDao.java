package com.realstore.services.dao;

import com.realstore.models.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DataBaseServiceDao {

    void createConnection();

    boolean addUser(User user);

    boolean deleteUser(UUID userId);

    boolean updateUserPassword(UUID userId, String newUserPassword);

    boolean updateUserInformation(UUID userId, User user);

    Optional<User> getUserById(UUID userId);

    Optional<User> getUserByName(String userName);

    List<User> getAllUsers();
}
