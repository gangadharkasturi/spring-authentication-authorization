package com.gangadhar.springsecurityauthenticationauthorization.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gangadhar.springsecurityauthenticationauthorization.entity.Users;


public interface UserRepository extends JpaRepository<Users, Integer> {
	
	Optional<Users> findByName(String userName);

}
