package com.docusecure.docprocessingsystem.controller;


import com.docusecure.processingsystem.model.User;
import com.docusecure.processingsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/login")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User createUser(@RequestBody User user) {
       return userService.saveUser(user);
    }

}
