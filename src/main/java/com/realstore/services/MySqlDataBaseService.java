package com.realstore.services;

import com.realstore.services.dao.DataBaseServiceDao;
import com.realstore.models.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.realstore.exceptions.RealStoreException.CONNECTION_FAIL;

@Repository("mysql")
public class MySqlDataBaseService implements DataBaseServiceDao {

    private Connection connection;
    private final ErrorHandlingService errorHandlingService;

    public MySqlDataBaseService() {
        this.errorHandlingService = ErrorHandlingService.getErrorHandlingService();
        createConnection();
    }

    @Override
    public void createConnection() {
        try {
            connection = DriverManager.getConnection("", "username", "password");
        } catch (SQLException ex) {
            this.errorHandlingService.setMessage(CONNECTION_FAIL);
        }
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
