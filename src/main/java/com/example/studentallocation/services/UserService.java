package com.example.studentallocation.services;

import com.example.studentallocation.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);

    User registerUser(User user);

    User updateProfile(Long userId, User updatedUser);
}

