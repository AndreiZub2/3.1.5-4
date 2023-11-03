package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
public class ViewController {

    private final UserService userService;

    public ViewController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }


    @GetMapping("/admin")
    public String printUsers(ModelMap model, Principal principal) {
        model.addAttribute("userAdmin", userService.getNameUser(principal.getName()));
        return "all-user";
    }

    @GetMapping("/page/api/user")
    public String userPage(Model model, Principal principal) {
        model.addAttribute("userUser", userService.getNameUser(principal.getName()));
        return "user";
    }

}
