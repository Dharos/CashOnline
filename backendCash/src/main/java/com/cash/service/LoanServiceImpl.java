package com.cash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cash.model.Loan;
import com.cash.repository.LoanRepository;

@Service
public class LoanServiceImpl implements ILoanService {
	
	@Autowired
	private LoanRepository loanRepo;
	
	@Override
	public List<Loan> getAllLoans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Loan> findPaginatedLoansByUser(int page, int size, Long userId) {
		Pageable pageable = (Pageable) PageRequest.of(page, size);
		return loanRepo.findByUserId(pageable,userId);
		
	}

	@Override
	public Page<Loan> findPaginatedLoans(int page, int size) {
		// TODO Auto-generated method stub
		return loanRepo.findAll((Pageable) PageRequest.of(page, size));
	}
}
