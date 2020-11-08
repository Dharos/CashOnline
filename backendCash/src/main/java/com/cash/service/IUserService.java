package com.cash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cash.model.User;

public interface IUserService {
	
	public List<User> getAllUsers();
	public Optional<User> getUserById(Long id);	
	
	public User addUser(User newUser);
	public ResponseEntity<Void> deleteUser(Long id);
}
