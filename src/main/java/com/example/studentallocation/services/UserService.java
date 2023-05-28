package com.example.studentallocation.services;

import com.example.studentallocation.models.User;
import com.example.studentallocation.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User registerUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setAdmin(false);
        return userRepository.save(user);
    }

    public String loginUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null && bCryptPasswordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            // Generate JWT token
            String token = Jwts.builder()
                    .setSubject(existingUser.getEmail())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 hours
                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
                    .compact();
            return token;
        } else {
            throw new IllegalArgumentException("Invalid Credentials");
        }
    }
    public User updateProfile(Long userId, User updatedUser) {
        User user = getUserById(userId);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(updatedUser.getPassword()));

        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        User user = getUserById(userId);
        userRepository.delete(user);
    }

    private User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    private String generateJwtToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 hours
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}

