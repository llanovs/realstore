package com.realstore.controllers;


import com.realstore.exceptions.RealStoreException;
import com.realstore.models.User;
import com.realstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.realstore.exceptions.RealStoreException.USER_DOES_NOT_FIND;

@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("registration")
    public ModelAndView getRegistrationPage() {
        return new ModelAndView("registration.html");
    }

    @PostMapping("registration")
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login.html");
    }

    @PostMapping("login")
    public Optional<User> login(@RequestBody User user) throws RealStoreException {
        Optional<User> userFromDb = userService.getUserByName(user.getName());
        if(userFromDb.isPresent() && user.getPassword().equals(userFromDb.get().getPassword())){
            return userFromDb;
        }
        throw new RealStoreException(USER_DOES_NOT_FIND);
    }

    @PutMapping("updateUser/{id}")
    public boolean update(@PathVariable("id") UUID userId, @RequestBody User newUser) {
        return userService.updateUserInformation(userId, newUser);
    }

    @PutMapping("updatePassword/{id}")
    public boolean updatePassword(@PathVariable("id") UUID userId, @RequestBody User newUser) {
        return userService.updateUserInformation(userId, newUser);
    }

    @DeleteMapping(value = "delete/{id}")
    public boolean deleteUser(@PathVariable("id") UUID userId) {
        return userService.deleteUser(userId);
    }

    @GetMapping(value = "getUserByName/{userName}")
    public User getUserByName(@PathVariable("userName") String userName) {
        return userService.getUserByName(userName).orElse(null);
    }

    @GetMapping(value = "getUserById/{id}")
    public User getUserById(@PathVariable("id") UUID userId) {
        return userService.getUserById(userId).orElse(null);
    }
}
