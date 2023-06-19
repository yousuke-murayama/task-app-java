package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> findAll() {
		List<User> userList = userRepository.findAll();
		
		return userList;
	}
	
	public void insert(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		userRepository.insert(user);
	}
	
	public User login(String email, String password) {
		User user = userRepository.findByEmail(email);
		
		if(user == null) {
			return null;
		}
		
		if(!passwordEncoder.matches(password, user.getPassword())) {
			return null;
		}
		
		return user;
	}
	
}
