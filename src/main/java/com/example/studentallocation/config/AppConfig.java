package com.example.studentallocation.config;

import com.example.studentallocation.services.ClassroomService;
import com.example.studentallocation.services.ClassroomServiceImpl;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public ClassroomService classroomService() {
        return new ClassroomServiceImpl();
    }

//    @Bean
//    public UserService userService() {
//        return new UserServiceImpl();
//    }
}
