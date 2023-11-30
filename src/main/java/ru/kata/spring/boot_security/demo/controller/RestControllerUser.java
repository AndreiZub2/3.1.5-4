package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.exceptions.NoUserException;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/page")
public class RestControllerUser {

    private final UserService userService;

    @Autowired
    public RestControllerUser(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public User showUser(Principal principal) {
        User user = userService.getNameUser(principal.getName());
        if (user == null) {
            throw new NoUserException("User not found");
        }
        return user;
    }
}
