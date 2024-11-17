package com.example.nandini.repository;


	import org.springframework.data.mongodb.repository.MongoRepository;
	import org.springframework.stereotype.Repository;

import com.example.nandini.model.AuthUser;

import java.util.Optional;

	@Repository
	public interface AuthUserRepository extends MongoRepository<AuthUser, String> {
	    Optional<AuthUser> findByUsername(String username);

		Optional<AuthUser> findById(Long id);

		void deleteById(Long id);
	
	
	}

