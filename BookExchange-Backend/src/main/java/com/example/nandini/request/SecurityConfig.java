package com.example.nandini.request;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


//    @Bean
//    public SecurityFilterChain defaultFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf(csrf-> csrf.disable())
//                .authorizeHttpRequests(auth-> auth.requestMatchers("/api/users/register","/error").permitAll()
//                .anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults())
//                .build();
//    }
	
	
	    
	 @Bean
	    public SecurityFilterChain defaultFilterChain(HttpSecurity httpSecurity) throws Exception {
	        return httpSecurity
	                .csrf(csrf -> csrf.disable())
	                .authorizeHttpRequests(auth -> auth
	                    .requestMatchers("/api/users/register", "/api/users/login", "/api/users/getallUsers","/api/books/**", "/exchange-requests/**",  "/error").permitAll()
	                    .anyRequest().authenticated())
	                .httpBasic(Customizer.withDefaults())
	                .formLogin(Customizer.withDefaults())
	                .logout(logout -> logout.logoutUrl("/api/users/logout")) // Specify logout URL
	                .build();
	    }
	 
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    
}

