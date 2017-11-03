package com.ektello.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ektello.demo.dtos.UserDTO;
import com.ektello.demo.entities.User;
import com.ektello.demo.repositiories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public void addUser(UserDTO dto) {
		dto.Validate();
		userRepository.save(new User(dto));
		
	}
	
	public List<User> getAllUsers() {
		List<User> toBeReturned = new ArrayList<>();
		userRepository.findAll().forEach(toBeReturned :: add);
		return toBeReturned;
	}
	
}
