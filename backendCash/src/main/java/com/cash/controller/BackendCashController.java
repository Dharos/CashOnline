package com.cash.controller;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cash.model.Loan;
import com.cash.model.User;
import com.cash.service.ILoanService;
import com.cash.service.IUserService;

@RestController
@RequestMapping("/")
public class BackendCashController {
	
	public final Log LOGGER = LogFactory.getLog(BackendCashController.class);
	
	@Autowired
	private IUserService userSrv;
	
	@Autowired
	private ILoanService loanSrv;
	
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userSrv.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id){
		return userSrv.getUserById(id);
	}
	
	@GetMapping("/loans")
	public Page<Loan> getAllLoans(@RequestParam(name="page", required=true, defaultValue="1") int page,
								  @RequestParam(name="size", required=true, defaultValue="1") int size,
								  @RequestParam(name="user_id", required=false ) Long userId){
		try {
			int pageInternal = page-1;
			checkPage(pageInternal);
			if(userId==null) {
				return loanSrv.findPaginatedLoans(pageInternal, size);
			}else {
				return loanSrv.findPaginatedLoansByUser(pageInternal, size, userId);
			}
		} catch (IllegalArgumentException e) {
			LOGGER.error(e.getMessage(),e);
			throw e;
		}
		
		
		
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User newUser) {
		
		return userSrv.addUser(newUser);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		return userSrv.deleteUser(id);
	}
	
	private void checkPage(int page) {
		if(page<0) {
			throw new IllegalArgumentException("Page index must not be less than one!");
		}
	}
}
