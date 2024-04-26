package com.ty.realestateservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.realestateservice.dto.Admin;
import com.ty.realestateservice.dto.Customer;
import com.ty.realestateservice.dto.EnqiuryForm;
import com.ty.realestateservice.service.AdminService;
import com.ty.realestateservice.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/admins")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	@ApiOperation(value = " save admin", notes = "admin obj and it gives admin id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "succesfully created") , @ApiResponse(code = 400, message = "BAD REQUEST")})
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin( @RequestBody Admin admin){
		return adminService.saveAdmin(admin);
		
	}
	
	@ApiOperation(value = " get Admin", notes = "takes admin id and gives admin object")
	@ApiResponses(value= {@ApiResponse(code = 200, message = "getting admin by id"), @ApiResponse(code = 404, message = "NOT FOUND")})
	@GetMapping(value="/{id}" ,produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> getAdminById( @PathVariable int id)
	{
		return adminService.getAdminById(id);  
	}
	
	@ApiOperation(value = " delete admin", notes = "takes id and deletes admin object")
	@ApiResponses(value= {@ApiResponse(code = 200, message = "succesfully deleted"), @ApiResponse(code = 404, message = "NOT FOUND")})
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteAdminById(@PathVariable int id)
	{
		return adminService.deleteAdminById(id);
	}
	
	@ApiOperation(value = "finds admin", notes = "takes id and gives object")
	@ApiResponses(value= {@ApiResponse(code = 200, message = "succesfully fetched"), @ApiResponse(code = 404, message = "NOT FOUND")})
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> findAdminByEmail(@RequestParam String email)
	{
		return adminService.findAdminByEmail(email); 
	}

	@ApiOperation(value = "update admin", notes = "takes admin object and gives updated admin object")
	@ApiResponses(value= {@ApiResponse(code = 200, message = "succesfully updated"), @ApiResponse(code = 404, message = "NOT FOUND")})
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody  Admin admin)
	{
		return adminService.updateAdmin(admin);
	}
	
	@ApiOperation(value = " save admin", notes = "admin obj and it gives admin id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "succesfully created") , @ApiResponse(code = 400, message = "BAD REQUEST")})
	@PutMapping(value="/{id}", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<EnqiuryForm>> replyQueryCustomer(@PathVariable int id, @RequestBody EnqiuryForm enqiuryForm) {
		return adminService.replyCustomer( id,enqiuryForm);
		
	}
	

}
