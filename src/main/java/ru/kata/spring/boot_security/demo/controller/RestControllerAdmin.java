package ru.kata.spring.boot_security.demo.controller;




import org.springframework.web.bind.annotation.*;


import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.NoUserException;
import ru.kata.spring.boot_security.demo.service.UserService;


import java.util.List;


@RestController
@RequestMapping("/api")
public class RestControllerAdmin {


    private final UserService userService;

    public RestControllerAdmin(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> allUser() {
        return userService.getUserList();
    }

    @GetMapping("/users/{id}")
    public User getUser (@PathVariable Long id){
        User user = userService.getUser(id);
        if (user == null){
            throw new NoUserException("There is no user with ID = " + id + " in Database");
        }
        return  user;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id){
        User user = userService.getUser(id);
        if(user==null){
            throw new NoUserException("User ID = " + id + " not found");
        }
    userService.deleteUser(id);
    return "User ID = " + id + " deleted";
    }






}
