package com.hospital.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.evaluation.model.User;

public interface AuthRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username); 
}
