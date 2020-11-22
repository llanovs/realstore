package com.store.realstore.controllers;

import com.store.realstore.constants.Constants;
import com.store.realstore.models.User;
import com.store.realstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private String userName = "Liliia";
    private String userPassword  = "111";

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public ModelAndView getMainPage() {
        return new ModelAndView("index.html");
    }

    @RequestMapping(value = "/user")
    public ModelAndView getUserPage() {
        return new ModelAndView("user.html");
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam("userName") String userName,
                              @RequestParam("userPassword") String userPassword) {
        ModelAndView modelAndView = new ModelAndView("user.html");
        if (userService.checkUserCredential(userName, userPassword)) {
            setParameter(modelAndView, "userName", userName);
        } else {
            setParameter(modelAndView, "errorMessage", userService.getErrorMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/registration")
    public ModelAndView registrationUser(@Nullable @RequestParam("userName") String userName,
                                         @Nullable @RequestParam("userPassword") String userPassword) {

        ModelAndView modelAndView = new ModelAndView("registration.html");
        if (userService.addUser(userName, userPassword)) {
            String message = userService.addUser(userName, userPassword) ?
                    Constants.CREATE_USER : Constants.OPERATION_WAS_NOT_SUCCEED;
            setParameter(modelAndView, "userName", userName);
            setParameter(modelAndView, "message", message);
        } else if(userService.getErrorMessage() != null){
            setParameter(modelAndView, "errorMessage", userService.getErrorMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/account")
    public ModelAndView changeAccountInfo(@Nullable @RequestParam("userName") String userName,
                                          @Nullable @RequestParam("userPassword") String userPassword) {
        //only for test
        userName = this.userName;
        userPassword = this.userPassword;

        ModelAndView modelAndView = new ModelAndView("account.html");
        if (userService.checkUserCredential(userName, userPassword)) {
            setParameter(modelAndView, "userName", userName);
        } else {
            setParameter(modelAndView, "errorMessage", userService.getErrorMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/changePassword")
    public ModelAndView changeUserPassword(@Nullable @RequestParam("userName") String userName,
                                           @Nullable @RequestParam("oldUserPassword") String oldUserPassword,
                                           @Nullable @RequestParam("newUserPassword") String newUserPassword) {

        //only for test
        userName = this.userName;
        oldUserPassword = this.userPassword;
        newUserPassword = "1";

        ModelAndView modelAndView = new ModelAndView("account.html");
        if (userService.updateUserPassword(userName, oldUserPassword, newUserPassword)) {
            String message = userService.updateUserPassword(userName, oldUserPassword, newUserPassword) ?
                    Constants.CHANGE_USER_PASSWORD : Constants.OPERATION_WAS_NOT_SUCCEED;
            setParameter(modelAndView, "userName", userName);
            setParameter(modelAndView, "message", message);
        } else {
            setParameter(modelAndView, "errorMessage", userService.getErrorMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/changeInformation")
    public ModelAndView changeUserInformation(@Nullable @RequestParam("userName") String userName) {

        //only for test
        userName = this.userName;

        ModelAndView modelAndView = new ModelAndView("account.html");
        String message = userService.updateUserInformation(userName) ?
                Constants.CHANGE_USER_INFO : Constants.OPERATION_WAS_NOT_SUCCEED;
        setParameter(modelAndView, "userName", userName);
        setParameter(modelAndView, "message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/showInformation")
    public ModelAndView showUserInformation(@Nullable @RequestParam("userName") String userName) {

        //only for test
        userName = this.userName;

        ModelAndView modelAndView = new ModelAndView("account.html");
        User user = userService.showUserInfo(userName);
        modelAndView.addObject("userData", user);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteUser")
    public ModelAndView deleteUser(@Nullable @RequestParam("userName") String userName,
                                   @Nullable @RequestParam("userPassword") String userPassword) {

        //only for test
        userName = this.userName;
        userPassword = this.userPassword;

        ModelAndView modelAndView = new ModelAndView("account.html");
        String message = userService.deleteUser(userName, userPassword) ?
                Constants.DELETE_USER : Constants.OPERATION_WAS_NOT_SUCCEED;
        setParameter(modelAndView, "message", message);
        return modelAndView;
    }

    private void setParameter(ModelAndView modelAndView, String key, String message) {
        modelAndView.addObject(key, message);
    }
}
