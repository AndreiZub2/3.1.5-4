package ru.kata.spring.boot_security.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;


@Controller

public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/admin")
    public String admin(Model model){
        List<User> userList = userService.getUserList();
        model.addAttribute("allUsr", userList);
        return "all-user";
    }
    //"/addNewUsers"
    @RequestMapping("/addNewUsers")
    public String addNewUsers(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "user-info";
    }
//"/saveUser"
    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/admin";
    }
//"/updateInfo"
    @RequestMapping( "/updateInfo")
    public String updateUser(@RequestParam("usrId") Long id, Model model){
        User user  = userService.getUser(id);
        model.addAttribute("user", user);
        return "redirect:/admin";
    }
//"/deleteUser"
    @RequestMapping( "/deleteUser")
    public String deleteUser(@RequestParam("usrId")Long id){
    userService.deleteUser(id);
        return "redirect:/admin";
    }

}
