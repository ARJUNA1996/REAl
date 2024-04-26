package com.ty.realestateservice.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.realestateservice.dto.Admin;
import com.ty.realestateservice.dto.Customer;
import com.ty.realestateservice.dto.EnqiuryForm;
import com.ty.realestateservice.repository.AdminRepository;
import com.ty.realestateservice.repository.CustomerRepository;
import com.ty.realestateservice.repository.EnquryRepository;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private  EnquryRepository enquryRepository;

	public Customer saveCustomer(Customer customer) {

		return customerRepository.save(customer);
	}

	public Customer getCustomerById(int id) {

		Optional<Customer> customer = customerRepository.findById(id);

		if (customer.isPresent()) {
			return customer.get();
		}
		return null;

	}

	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	public boolean deleteCustomerById(int id) {
		Customer customer = getCustomerById(id);
		if (customer != null) {
			return true;
		}
		return false;
	}

	public Customer updateCustomer(Customer customer) {
		Optional<Customer> optional = customerRepository.findById(customer.getId());
		if (optional != null) {
			return customerRepository.save(customer);
		} else {
			return null;
		}
	}

	public Customer getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
	
	public EnqiuryForm savEnqiuryForm(EnqiuryForm enqiuryForm) {
		return enquryRepository.save(enqiuryForm);
	}

}
