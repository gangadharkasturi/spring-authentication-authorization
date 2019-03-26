package com.gangadhar.springsecurityauthenticationauthorization.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gangadhar.springsecurityauthenticationauthorization.entity.CustomUserDetails;
import com.gangadhar.springsecurityauthenticationauthorization.entity.Users;
import com.gangadhar.springsecurityauthenticationauthorization.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Users> optionalUsers = userRepository.findByName(userName);
		optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUsers.map(CustomUserDetails::new).get();
	}

}
