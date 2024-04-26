package com.ty.realestateservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.realestateservice.dto.House;
import com.ty.realestateservice.dto.Location;
import com.ty.realestateservice.service.HouseService;
import com.ty.realestateservice.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/house")
public class HouseController {

	@Autowired
	HouseService houseService;
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "successfully created"),
			@ApiResponse(code = 400, message = "Bad Request") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<House>> saveHouse(@RequestBody House house) {
		return houseService.saveHouse(house);
	}
	
	@ApiOperation(value = "Get customer By Id",notes = "getting customer object by using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success") , @ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<House>> findById(@PathVariable int id) {
		return houseService.findById(id);
	}
	
	@ApiOperation(value = "Get customer By Id",notes = "getting customer object by using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success") , @ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(value = "/bhk",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<House>>> findAllHouseByBhk(@RequestParam int bhk) {
		return houseService.findAllHouseByBhk(bhk);
	}
	
	@ApiOperation(value = "Get customer By Id",notes = "getting customer object by using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success") , @ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(value = "/location/{location}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<Location>>> findByLocation(@PathVariable String location) {
		return houseService.findByLocation(location);
	}
}
