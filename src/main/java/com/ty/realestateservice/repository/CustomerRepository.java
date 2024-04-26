package com.ty.realestateservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.realestateservice.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	Customer findByEmail(String email);
	

}
