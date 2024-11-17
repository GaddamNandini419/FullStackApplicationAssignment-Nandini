package com.example.nandini.model;



	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.index.Indexed;
	import org.springframework.data.mongodb.core.mapping.Document;


	@Document("user")
	public class AuthUser {
	    @Id
	    private String id;
	    @Indexed
	    private String username;
	    private String email;
	    private String password;
	    private boolean active;
	    private String role; // Role field to specify USER or ADMIN
	    
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
	    
	    
	    
		
	    
	    
	}


