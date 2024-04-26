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

import com.ty.realestateservice.dto.InteriorDesigners;
import com.ty.realestateservice.service.InteriorDesignersService;
import com.ty.realestateservice.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/designers")
public class InteriorDesignersController {
	@Autowired
	private InteriorDesignersService interiorDesignersService;

	@ApiOperation(value = "save interior designer", notes = "input is interior designer object and returns object with generated id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully saved"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<InteriorDesigners>> saveInteriorDesigners( @RequestBody
			InteriorDesigners interiorDesigners) {
		return interiorDesignersService.saveInteriorDesigners(interiorDesigners);
	}

	@ApiOperation(value = "fetch interior designers", notes = "input is interior designers id and returns object with given id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@GetMapping(value = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<InteriorDesigners>> getInteriorDesignersById(@PathVariable int id) {
		return interiorDesignersService.getInteriorDesignersById(id);
	}
	

	@ApiOperation(value = "remove interior designers object by Id", notes = "input interior designers id returns message object is deleted or not")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@DeleteMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteInteriorDesignersById(@RequestParam int id) {
		return interiorDesignersService.deleteInteriorDesignersById(id);
	}
	
	@ApiOperation(value = "fetch interior designers by email", notes = "input is inerior deigners location and returns object with given location")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@GetMapping(value = "/email/{email}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<InteriorDesigners>> findInteriorDesignersByEmail(@PathVariable String email) {
		return interiorDesignersService.findInteriorDesignersByEmail(email);
	}
	@ApiOperation(value = "fetch interior designers by location", notes = "input is interior desiners and returns object with given location")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@GetMapping(value = "/location/{location}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<InteriorDesigners>> findInteriorDesignersByLocation(@PathVariable String location) {
		return interiorDesignersService.findInteriorDesignersByEmail(location);
	}
	@ApiOperation(value = "fetch interior designers", notes = "input is interior designers id and returns object with given id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<InteriorDesigners>> updateInteriorDesigners(@RequestBody
			InteriorDesigners interiorDesigners) {
		return interiorDesignersService.updateInteriorDesigners(interiorDesigners); 

	}
}
