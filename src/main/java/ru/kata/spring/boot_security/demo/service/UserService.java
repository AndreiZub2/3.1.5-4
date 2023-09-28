package ru.kata.spring.boot_security.demo.service;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService{


    List<User> getUserList();
    void saveUser(User user);
    User getNameUser(String username);
    User getUser(Long id);

    void updateUser( User user);

    void deleteUser(Long id);

}
