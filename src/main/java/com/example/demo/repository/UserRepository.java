package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Medicines;
import com.example.demo.model.Users;



public interface UserRepository extends JpaRepository<Users,Long>{
	
	public Users findByUsername(String username);

	public Users findByUsernameAndPassword(String username, String password);

	
	
	

}
