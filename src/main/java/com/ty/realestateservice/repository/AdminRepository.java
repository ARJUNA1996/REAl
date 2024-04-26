package com.ty.realestateservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.realestateservice.dto.Admin;
import com.ty.realestateservice.dto.EnqiuryForm;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByEmail(String email);
	
	

}
