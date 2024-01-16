//package com.springsecurity.springsecurityexample.controller;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private Consumer[] consumers = {
//        new Consumer("user1", "password1", "USER"),
//        new Consumer("admin1", "password2", "ADMIN")
//    };
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/admin").hasRole("ADMIN") // Only ADMIN role can access /admin endpoint
//            .anyRequest().authenticated()
//            
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        for (Consumer consumer : consumers) {
//            auth.inMemoryAuthentication()
//                .withUser(consumer.getUsername())
//                .password("{noop}" + consumer.getPassword()) // {noop} is used to indicate plaintext password
//                .roles(consumer.getRole());
//        }
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//}
