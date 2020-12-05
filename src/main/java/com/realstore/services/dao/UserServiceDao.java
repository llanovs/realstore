package com.realstore.services.dao;

import com.realstore.models.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserServiceDao {

    boolean addUser(User user);

    boolean updateUserPassword(UUID userId, User user);

    boolean updateUserInformation(UUID userId, User user);

    boolean deleteUser(UUID userId);

    Optional<User> getUserByName(String userName);

    Optional<User> getUserByNameAndPassword(String userName, String userPassword);

    List<User> getAllUsers();

    Optional<User> getUserById(UUID id);
}
