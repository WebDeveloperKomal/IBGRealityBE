package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Entity.LoginUserDetails;

import jakarta.persistence.Id;

public interface LoginUserDetailsRepository extends JpaRepository<LoginUserDetails, Integer> {

	
	@Query("SELECT u FROM LoginUserDetails u WHERE u.email = :email")
	Optional<LoginUserDetails> findByEmail(@Param("email") String email);

	
}
