//package com.example.studentallocation.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        // Configure authentication provider, user details service, etc.
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                // Configure access rules for specific URLs
//                .antMatchers("/api/admin/**").hasRole("ADMIN")
//                .antMatchers("/api/user/**").hasRole("USER")
//                .anyRequest().authenticated()
//                .and()
//                // Configure login and logout URLs
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .logout().logoutUrl("/logout").permitAll();
//    }
//}