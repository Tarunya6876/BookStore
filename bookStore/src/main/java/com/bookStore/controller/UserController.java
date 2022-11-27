package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookStore.model.User;
import com.bookStore.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    private ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(this.userService.getUser());
    }

    @GetMapping("/user/{userId}")
    private User getUserById(@PathVariable long userId){
        return this.userService.getUserById(userId);
    }

    @PostMapping("/user")
    private ResponseEntity<User> saveUser(@RequestBody User usr){
        return ResponseEntity.ok().body(this.userService.createUser(usr));
    }

    @PutMapping("/user/{userId}")
    private ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User usr){
        usr.setUserId(userId);
        return ResponseEntity.ok().body(this.userService.updateUser(usr));
    }

    @PutMapping("/user/{userId}/suspend")
    private ResponseEntity<User> suspendUser(@PathVariable int userId, @RequestBody User usr){
        usr.setUserId(userId);
        return ResponseEntity.ok().body(this.userService.suspendUser(usr));
    }

}




