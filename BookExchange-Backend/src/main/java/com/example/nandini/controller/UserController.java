
package com.example.nandini.controller;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nandini.model.AuthUser;
import com.example.nandini.repository.AuthUserRepository;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

	@Autowired
	private AuthUserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	

	@PostMapping("/register")
	public ResponseEntity registerUser(@RequestBody AuthUser user) {
		try {
			if (userRepository.findByUsername(user.getUsername()).isPresent())
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already taken. Please try again");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			AuthUser save = userRepository.save(user);
			return ResponseEntity.ok(HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@GetMapping("/getallUsers")
    public ResponseEntity<List<AuthUser>> getAllUsers() {
        try {
            List<AuthUser> users = userRepository.findAll();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
	
	
	
	
	 @PostMapping("/logout") // Logout
	    public ResponseEntity<?> logoutUser() {
	        // In Spring Security, logout is typically handled automatically by the framework.
	        return ResponseEntity.ok("Logout successful");
	    }
	 
	 @GetMapping("/{id}") // Get user by ID
	    public ResponseEntity<AuthUser> getUserById(@PathVariable Long id) {
	        Optional<AuthUser> user = userRepository.findById(id);
	        return user.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
	 
	 
	 // New Delete User Endpoint
		@DeleteMapping("/{id}")  // Delete user by ID
		public ResponseEntity<String> deleteUser(@PathVariable Long id) {
			try {
				Optional<AuthUser> user = userRepository.findById(id);
				if (!user.isPresent()) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
				}
				
				userRepository.deleteById(id);  // Delete the user
				return ResponseEntity.ok("User deleted successfully");
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
			}
		}
	 
	 
	 
}
