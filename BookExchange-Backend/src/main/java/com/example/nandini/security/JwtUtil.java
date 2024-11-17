package com.example.nandini.security;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtUtil {
    public static void main(String[] args) {
        // Secret key to sign the JWT
        String secretKey = "your_secret_key";

        // Create the JWT token
        String jwt = Jwts.builder()
                .setSubject("user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour expiration
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        // Print the generated JWT token
        System.out.println("Generated JWT Token: " + jwt);
    }

	public String generateToken(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
