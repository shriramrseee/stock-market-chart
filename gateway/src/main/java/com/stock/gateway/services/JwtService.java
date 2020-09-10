package com.stock.gateway.services;

import com.stock.gateway.models.User;
import com.stock.gateway.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepo userRepo;
	
	public UserDetails loadUserByUsername(String input_username) throws UsernameNotFoundException {
		User user = getUserByName(input_username);
		if (user.getName().equals(input_username)) {
			return new org.springframework.security.core.userdetails.User(
					user.getName(), passwordEncoder.encode(user.getPassword()), new ArrayList<>()
			);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + user.getName());
		}
	}

	public User getUserByName(String name) {
		return userRepo.findByName(name);
	}

	public void addUser(User user) {
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
	}
}
