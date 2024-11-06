package com.dame_mansour.app_spring_security.controller;

import com.dame_mansour.app_spring_security.entities.User;
import com.dame_mansour.app_spring_security.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/users")
    public String getUsers(){
        return "Hello Users";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String getAdmin(){
        return "Hello Admin";
    }

//    @PostMapping("/register")
//    public ResponseEntity<Void> registerUser(@RequestBody User user) {
//        userService.saveUser(user);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }


}
