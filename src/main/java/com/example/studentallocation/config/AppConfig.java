package com.example.studentallocation.config;

import com.example.studentallocation.repositories.UserRepository;
import com.example.studentallocation.services.ClassroomService;
import com.example.studentallocation.services.ClassroomServiceImpl;
import com.example.studentallocation.services.UserService;
import com.example.studentallocation.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public ClassroomService classroomService() {
        return new ClassroomServiceImpl();
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }
}
