package com.ty.realestateservice.service;

import org.springframework.http.HttpStatus;

import com.ty.realestateservice.dao.AdminDao;
import com.ty.realestateservice.dao.CustomerDao;
import com.ty.realestateservice.dto.Admin;
import com.ty.realestateservice.dto.Customer;
import com.ty.realestateservice.dto.EmailDetails;
import com.ty.realestateservice.dto.EnqiuryForm;
import com.ty.realestateservice.exception.NoIdFoundException;
import com.ty.realestateservice.repository.EnquryRepository;
import com.ty.realestateservice.util.ResponseStructure;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private EnquryRepository enquryRepository;
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		responseStructure.setStatus(200);
		responseStructure.setMessage("passed");
		responseStructure.setData(adminDao.saveAdmin(admin));
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int id) {
		ResponseEntity<ResponseStructure<Admin>> resp;
		Admin admin = adminDao.getAdminById(id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();

		if (admin != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("passed");
			responseStructure.setData(admin);

			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);

		} else {
			throw new NoIdFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteAdminById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (adminDao.deleteAdminById(id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("id deleted");
			responseStructure.setData("admin with given id deleted");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<Admin>> findAdminByEmail(String email) {
		ResponseEntity<ResponseStructure<Admin>> resp;
		Admin admin = adminDao.findAdminByEmail(email);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();

		if (admin != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("passed");
			responseStructure.setData(admin);

			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);

		} else {
			throw new NoIdFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin) {
		Admin admin1 = adminDao.updateAdmin(admin);

		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();

		if (admin1 != null) {
			responseStructure.setMessage("updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(admin1);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.NOT_FOUND);

		}
	}

	public ResponseEntity<ResponseStructure<EnqiuryForm>> replyCustomer(int id, EnqiuryForm enqiuryForm) {
		
		Optional<EnqiuryForm> enqiuryForm1 =enquryRepository.findById(id);
		ResponseStructure<EnqiuryForm> responseStructure = new ResponseStructure<EnqiuryForm>();

		if (enqiuryForm1!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated succefully");
			enqiuryForm1.get().setReply(enqiuryForm.getReply());
			responseStructure.setData(enquryRepository.save(enqiuryForm1.get()));
			EmailDetails details = new EmailDetails();
			details.setSubject("Reply");
			details.setMsgBody(enqiuryForm1.get().getReply());
			details.setRecipient(enqiuryForm1.get().getEmail());
			emailServiceImpl.sendSimpleMail(details);
			System.out.println("mail sent");
			return new ResponseEntity<ResponseStructure<EnqiuryForm>>(responseStructure, HttpStatus.OK);

		} else {
			throw new NoIdFoundException();
		}
		
	}

}
