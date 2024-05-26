package com.storefinder.StoreLocator.controller;

import com.storefinder.StoreLocator.model.Store;
import com.storefinder.StoreLocator.model.User;
import com.storefinder.StoreLocator.repository.SearchRepository;
import com.storefinder.StoreLocator.repository.UserRepository;
import com.storefinder.StoreLocator.repository.UserSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserSearchRepository userSearchRepository;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //to fetch users based on roles
    @GetMapping("/users/{role}")
    public List<User> search(@PathVariable String role){
        return userSearchRepository.findByRole(role);
    }

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
