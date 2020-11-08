package com.cash.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cash.model.Loan;

public interface ILoanService {
	
	public List<Loan> getAllLoans();
	public Page<Loan> findPaginatedLoansByUser(int page,int size,Long userId);
	public Page<Loan> findPaginatedLoans(int page,int size);
	
}
