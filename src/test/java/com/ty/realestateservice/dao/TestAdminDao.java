        package com.ty.realestateservice.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ty.realestateservice.dao.AdminDao;
import com.ty.realestateservice.dto.Admin;
import com.ty.realestateservice.repository.AdminRepository;

@SpringBootTest
public class TestAdminDao {

	@MockBean
	AdminRepository adminRepository;

	@Autowired
	AdminDao adminDao;

	Optional<Admin> optional;

	@BeforeEach
	public void test() {

		
		optional = Optional.of(new Admin());

	}

	@Test
	public void testSaveAdmin() {
		Admin admin=optional.get();
		when(adminRepository.save(admin)).thenReturn(admin);
		assertEquals(admin, adminDao.saveAdmin(admin));
	}
	
	public void testGetById() {
		
//		Optional<Admin> admin=Optional.ofNullable(optional.get());
		when(adminRepository.findById(1)).thenReturn(optional);
		assertEquals(optional.get(), adminDao.getAdminById(1));
		
	}
	
	public void getAllAdminTest() {
		
		List<Admin> admins = null;
		when(adminRepository.findAll()).thenReturn(admins);
		assertEquals(admins, adminDao.getAllAdmin());
	}
	
	

}
