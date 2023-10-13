package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class AdminController {


//    private final UserService userService;
//
//    public AdminController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @RequestMapping("/admin")
//    public String admin(Model model, Principal principal){
//        List<User> userList = userService.getUserList();
//        User user = new User();
//        User user1 = userService.getNameUser(principal.getName());
//        model.addAttribute("newUser",user);
//        model.addAttribute("user",user1);
//        model.addAttribute("allUsr", userList);
//        model.addAttribute("allRoles", user1.getRoles());
//
//        return "all-user";
//    }
//    @RequestMapping("/saveUser")
//    public String saveUser(@ModelAttribute("user") User user){
//        userService.saveUser(user);
//        return "redirect:/admin";
//    }
//
//    @PatchMapping("/{id}")
//    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user")User user){
//        userService.getUser(id);
//        userService.updateUser(user);
//        return "redirect:/admin";
//    }
//
//    @RequestMapping( "/deleteUser")
//    public String deleteUser(@RequestParam("usrId")Long id){
//        userService.deleteUser(id);
//        return "redirect:/admin";
//    }

}
