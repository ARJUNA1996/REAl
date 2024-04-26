package com.ty.realestateservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.realestateservice.dto.Admin;
import com.ty.realestateservice.dto.Customer;
import com.ty.realestateservice.dto.EnqiuryForm;
import com.ty.realestateservice.repository.AdminRepository;
import com.ty.realestateservice.repository.EnquryRepository;

@Repository
public class AdminDao {

	@Autowired
	AdminRepository adminRepository;
	@Autowired
	private EnquryRepository enquryRepository;
	
	@Autowired
	private CustomerDao customerDao;

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin getAdminById(int id) {
		Optional<Admin> optional = adminRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public boolean deleteAdminById(int id) {

		Admin admin = getAdminById(id);

		if (admin != null) {
			return true;
		}
		return false;

	}

	public Admin updateAdmin(Admin admin) {
		Optional<Admin> optional = adminRepository.findById(admin.getId());
		if (optional != null) {
			return adminRepository.save(admin);

		}

		return null;
	}

	public List<Admin> getAllAdmin() {

		return adminRepository.findAll();
	}

	public Admin findAdminByEmail(String email) {

		return adminRepository.findByEmail(email);
	}
	

	
	

}
