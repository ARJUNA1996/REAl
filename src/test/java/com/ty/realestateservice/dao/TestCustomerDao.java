package com.ty.realestateservice.dao;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ty.realestateservice.dto.Customer;
import com.ty.realestateservice.repository.AdminRepository;

@SpringBootTest
public class TestCustomerDao {

	@MockBean
	AdminRepository adminRepository;
	@Autowired
	CustomerDao customerDao;

	Optional<Customer> optional;

	

}