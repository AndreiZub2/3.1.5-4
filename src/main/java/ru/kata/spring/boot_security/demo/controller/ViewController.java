package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
public class ViewController {

    private final UserService userService;

    public ViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String printUsers(ModelMap model, Principal principal) {
        model.addAttribute("userAdmin", userService.getNameUser(principal.getName()));
        return "all-user";
    }

    @GetMapping("/api/user")
    public String userPage(Model model, Principal principal) {
        User user = userService.getNameUser(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }
}
