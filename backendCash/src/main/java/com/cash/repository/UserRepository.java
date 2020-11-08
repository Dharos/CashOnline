package com.cash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cash.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
