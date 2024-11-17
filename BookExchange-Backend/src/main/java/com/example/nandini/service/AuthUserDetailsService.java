package com.example.nandini.service;



	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.core.userdetails.UsernameNotFoundException;
	import org.springframework.stereotype.Service;

import com.example.nandini.model.AuthUser;
import com.example.nandini.repository.AuthUserRepository;

import java.util.Optional;

	@Service
	public class AuthUserDetailsService implements UserDetailsService {

		@Autowired
	    private  AuthUserRepository userRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<AuthUser> authUser = userRepository.findByUsername(username.toLowerCase());
	        if (!authUser.isPresent()) {
	            throw new UsernameNotFoundException(username);
	        } else {
	            return User.builder()
	                    .username(authUser.get().getUsername())
	                    .password(authUser.get().getPassword())
	                    .disabled(!authUser.get().isActive())
	                    .build();
	        }
	    }
	}

