package com.example.studentallocation.controllers;

import com.example.studentallocation.models.User;
import com.example.studentallocation.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Value("${jwt.secret}")
    private String jwtSecret;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

//    @PostMapping("/login")
//    public Map<String, String> loginUser(@RequestBody User user) {
//        String token = userService.loginUser(user);
//        Map<String, String> response = new HashMap<>();
//        response.put("token", token);
//        return response;
//    }

    @PutMapping("/update-profile/{userId}")
    public User updateProfile(@PathVariable Long userId, @RequestBody User updatedUser) {
        return userService.updateProfile(userId, updatedUser);
    }

    @DeleteMapping("/delete-user/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}


