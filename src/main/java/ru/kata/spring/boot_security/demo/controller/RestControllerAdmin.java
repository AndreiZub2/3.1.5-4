package ru.kata.spring.boot_security.demo.controller;


import org.springframework.web.bind.annotation.*;


import ru.kata.spring.boot_security.demo.exceptions.NoUserException;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;



import java.util.List;


@RestController
@RequestMapping("/api")
public class RestControllerAdmin {


    private final UserService userService;
    private final RoleService roleService;

    public RestControllerAdmin(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public List<User> allUser() {
        return userService.getUserList();
    }

    @GetMapping("/admin/role")
    public List<Role> allRoles() {
        return roleService.allRoles();
    }

    @GetMapping("/admin/{id}")
    public User getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        if (user == null) {
            throw new NoUserException("There is no user with ID = " + id + " in Database");
        }
        return user;
    }

    @PostMapping("/admin")
    public User addUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PatchMapping("/admin/{id}")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping("/admin/{id}")
    public String deleteUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        if (user == null) {
            throw new NoUserException("User ID = " + id + " not found");
        }
        userService.deleteUser(id);
        return "User ID = " + id + " deleted";
    }
}
