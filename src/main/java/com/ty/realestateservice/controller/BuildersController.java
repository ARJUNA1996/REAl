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
import org.springframework.web.bind.annotation.RestController;
import com.ty.realestateservice.dto.Builders;
import com.ty.realestateservice.service.BuildersService;
import com.ty.realestateservice.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping("/builders")
public class BuildersController {
	@Autowired
	
	private BuildersService buildersService;

	@ApiOperation(value = "save builder", notes = "input is builder object and returns object with generated id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully saved"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Builders>> saveBuilders(@RequestBody Builders builders) {
		return buildersService.saveBuilders(builders); 
	}
    
	@ApiOperation(value = "fetch builder", notes = "input is builder id and returns object with given id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@GetMapping(value = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Builders>> getBuildersById(@PathVariable int id) {
		return buildersService.getBuildersById(id);
	}
	
	@ApiOperation(value = "remove builder object by Id", notes = "input agent  id returns message object is deleted or not")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@DeleteMapping(value = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE }) 
	public ResponseEntity<ResponseStructure<String>> deleteBuilderById(@PathVariable int id) {
		return buildersService.deleteBuilderById(id);
	}

	@ApiOperation(value = "fetch builder by email", notes = "input is builder email and returns object with given email")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@GetMapping(value = "/{email}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Builders>> findBuildersByEmail(@PathVariable String email) {
		return buildersService.findBuildersByEmail(email);
	}

	@ApiOperation(value = "fetch builder by location", notes = "input is builder location and returns object with given location")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@GetMapping(value = "/loc/{location}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Builders>> findBuildersByLocation(@PathVariable String location) {
		return buildersService.findBuildersByLocation(location);
	}
	@ApiOperation(value = "fetch builder", notes = "input is builder id and returns object with given id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Builders>> updateBuilders(@RequestBody Builders builders) {
		return buildersService.updateBuidlers(builders); 
	}

}
