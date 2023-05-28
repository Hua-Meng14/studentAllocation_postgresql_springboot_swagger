package com.example.studentallocation.repositories;

import com.example.studentallocation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    User findByEmail(String email);
    List<User> findAll();
//    List<User> getAllUsers();
//    User getUserById(Long id);
//    User createUser(User user);
//    User updateUser(Long id, User user);
//    void deleteUser(Long id);
}
