package com.cash.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cash.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{
	
	@Query(value="SELECT l From Loan l Inner Join User u on l.userId = u.id Where u.id= :userID ")
	public Page<Loan> findByUserId(Pageable page,@Param("userID") Long userID);
	
}
