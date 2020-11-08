package com.cash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cash.model.User;
import com.cash.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();

	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepo.findById(id);
	}
	
	/***
	 * Post
	 */
	@Override
	public User addUser(User newUser) {
		// TODO Auto-generated method stub
		return userRepo.save(newUser);
	}
	
	public ResponseEntity<Void> deleteUser(Long id) {
		userRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
