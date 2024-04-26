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

import com.ty.realestateservice.dto.Architects;
import com.ty.realestateservice.service.ArchitectService;
import com.ty.realestateservice.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/architects")
public class ArchitectController {
	@Autowired
	private ArchitectService architectService;

	@ApiOperation(value = "save architect", notes = "input is architect object and returns object with generated id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully saved"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }) 
	public ResponseEntity<ResponseStructure<Architects>> saveArchitects(@RequestBody Architects architects) {
		return architectService.saveArchitects(architects);
	}

	@ApiOperation(value = "fetch architect", notes = "input is architect id and returns object with given id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@GetMapping(value = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Architects>> getArchitectsById(@PathVariable int id) {
		return architectService.getArchitectsById(id);
	}

	@ApiOperation(value = "remove architect object by Id", notes = "input agent  id returns message object is deleted or not")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@DeleteMapping(value = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteArchitectsById(@PathVariable int id) {
		return architectService.deleteArchitectsById(id);
	}
	
	@ApiOperation(value = "fetch architect by email", notes = "input is architect email and returns object with given email")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@GetMapping(value = "/{name}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Architects>> findArchitectsByEmail(String email) {
		return architectService.findArchitectsByEmail(email);
	}
	@ApiOperation(value = "fetch achitect by location", notes = "input is archiect location and returns object with given location")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@GetMapping(value = "/name/{name}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Architects>> findArchitectsByLocation(String location) {
		return architectService.findArchitectsByLocation(location);
	}
	@ApiOperation(value = "fetch architect", notes = "input is architect id and returns object with given id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Architects>> updateArchitects(@RequestBody Architects architects) {
		return architectService.updateArchitects(architects); 
	}

}
