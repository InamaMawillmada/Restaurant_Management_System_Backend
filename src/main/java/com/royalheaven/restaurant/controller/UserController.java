package com.royalheaven.restaurant.controller;

import com.royalheaven.restaurant.dao.UserEntity;
import com.royalheaven.restaurant.dto.User;
import com.royalheaven.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping
    public void setUser(@RequestBody User user){
        userService.setUser(user);
    }

    @GetMapping
    public Iterable<UserEntity> getUsers(){
        return userService.getUser();
    }

    //Search a user by Name
    @GetMapping("/search/{name}")
    public Iterable<UserEntity> getUsersByName(@PathVariable String name){
        return userService.getUsersByName(name);
    }

    //Authenticate user for registration
    @PostMapping("/authenticateUser")
    public ResponseEntity<Boolean> authenticateUser(@RequestBody User user) {
        boolean isAuthenticated = userService.authenticateUser(user);
        return ResponseEntity.ok().body(isAuthenticated);
    }
}
