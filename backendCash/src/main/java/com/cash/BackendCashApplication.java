package com.cash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cash.model.Loan;
import com.cash.model.User;
import com.cash.repository.LoanRepository;
import com.cash.repository.UserRepository;

@SpringBootApplication
public class BackendCashApplication implements CommandLineRunner  {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private LoanRepository loanRepo;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(BackendCashApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		userRepo.save(new User(1L, "juanCom@gmail.com", "Juan", "Horvat"));
		userRepo.save(new User(2L, "manu22@gmail.com", "Manuel", "Olivery"));
		userRepo.save(new User(3L, "fede77@gmail.com", "Federico", "Teplitz"));
		userRepo.save(new User(4L, "maxiK@gmail.com", "Maximiliano", "Klarich"));
		
		loanRepo.save(new Loan(1L, 22D, 2L));
		loanRepo.save(new Loan(2L, 84D, 2L));
		loanRepo.save(new Loan(3L, 77D, 2L));
		loanRepo.save(new Loan(4L, 99D, 2L));
		loanRepo.save(new Loan(5L, 77D, 2L));
		loanRepo.save(new Loan(6L, 245D, 2L));
		loanRepo.save(new Loan(7L, 78D, 2L));
		loanRepo.save(new Loan(8L, 39D, 2L));
		loanRepo.save(new Loan(9L, 97D, 2L));
		loanRepo.save(new Loan(10L, 78D, 2L));
		loanRepo.save(new Loan(11L, 35D, 2L));
		loanRepo.save(new Loan(12L, 927D, 2L));
		loanRepo.save(new Loan(13L, 78D, 2L));
		
		
	}

}
