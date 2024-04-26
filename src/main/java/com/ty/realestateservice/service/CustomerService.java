package com.ty.realestateservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.realestateservice.dao.CustomerDao;
import com.ty.realestateservice.dto.Customer;
import com.ty.realestateservice.dto.EmailDetails;
import com.ty.realestateservice.dto.EnqiuryForm;
import com.ty.realestateservice.exception.NoIdFoundException;
import com.ty.realestateservice.util.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private EmailServiceImpl emailServiceImpl;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		customer.setPassword(null);

		ResponseStructure<Customer> resposneStructure = new ResponseStructure<>();
		resposneStructure.setStatus(HttpStatus.OK.value());
		resposneStructure.setMessage("Created");
		resposneStructure.setData(customerDao.saveCustomer(customer));
		EmailDetails details = new EmailDetails();
		details.setRecipient(customer.getEmail());
		details.setSubject("Profile Crested in RealEstate");
		details.setMsgBody(customer.getName() + " Your Profile created Succesfully");
		emailServiceImpl.sendSimpleMail(details);
		return new ResponseEntity<ResponseStructure<Customer>>(resposneStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers() {

		List<Customer> customer = customerDao.getAllCustomer();
		ResponseStructure<List<Customer>> resposneStructure = new ResponseStructure<>();

		if (customer != null) {

			resposneStructure.setStatus(HttpStatus.OK.value());
			resposneStructure.setMessage("Created");
			resposneStructure.setData(customer);

			return new ResponseEntity<ResponseStructure<List<Customer>>>(HttpStatus.OK);
		} else {

			resposneStructure.setStatus(HttpStatus.OK.value());
			resposneStructure.setMessage("customer object is present");
			resposneStructure.setData(null);
			return new ResponseEntity<ResponseStructure<List<Customer>>>(resposneStructure, HttpStatus.OK);

		}
	}

	public ResponseEntity<ResponseStructure<String>> deleteCustomerById(int id) {

		ResponseStructure<String> resposneStructure = new ResponseStructure<>();

		boolean customer = customerDao.deleteCustomerById(id);
		if (customer) {
			resposneStructure.setStatus(HttpStatus.OK.value());
			resposneStructure.setMessage("succes");
			resposneStructure.setData("data is deleted");
			return new ResponseEntity<ResponseStructure<String>>(resposneStructure, HttpStatus.OK);

		}
		throw new NoIdFoundException("No data found ");
	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int id) {
		ResponseStructure<Customer> resposneStructure = new ResponseStructure<>();
		Customer customer = customerDao.getCustomerById(id);
		if (customer != null) {
			resposneStructure.setStatus(HttpStatus.OK.value());
			resposneStructure.setMessage("succes");
			resposneStructure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(resposneStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("Data is not present in the database");

		}

	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer) {

		ResponseStructure<Customer> resposneStructure = new ResponseStructure<>();

		Customer customer1 = customerDao.updateCustomer(customer);
		if (customer1 != null) {
			resposneStructure.setStatus(HttpStatus.OK.value());
			resposneStructure.setMessage("updated");
			resposneStructure.setData(customer1);
			return new ResponseEntity<ResponseStructure<Customer>>(resposneStructure, HttpStatus.OK);

		} else {
			resposneStructure.setStatus(HttpStatus.OK.value());
			resposneStructure.setMessage("customer object is not present");
			resposneStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Customer>>(resposneStructure, HttpStatus.OK);

		}

	}

	public ResponseEntity<ResponseStructure<EnqiuryForm>> savEnqiuryForm(EnqiuryForm enqiuryForm) {
		
		
		ResponseStructure<EnqiuryForm> resposneStructure = new ResponseStructure<>();
		resposneStructure.setStatus(200);
		resposneStructure.setMessage("feedback sent");
		resposneStructure.setData(customerDao.savEnqiuryForm(enqiuryForm));
		return new ResponseEntity<ResponseStructure<EnqiuryForm>>(resposneStructure, HttpStatus.OK);
		

	}

}
