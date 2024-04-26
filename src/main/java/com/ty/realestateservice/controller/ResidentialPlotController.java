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

import com.ty.realestateservice.dto.Location;
import com.ty.realestateservice.dto.ResidentialPlot;
import com.ty.realestateservice.service.ResidentialPlotService;
import com.ty.realestateservice.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/residentialPlot")
public class ResidentialPlotController {

	@Autowired
	ResidentialPlotService plotService;

	@ApiResponses(value = {@ApiResponse(code = 201, message = "successfully created"),
			@ApiResponse(code = 400, message = "Bad Request") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<ResidentialPlot>> saveResidentiaPlot(@RequestBody ResidentialPlot plot) {
		return plotService.saveResidentiaPlot(plot);
	}

	@ApiOperation(value = "Get customer By Id",notes = "getting customer object by using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success") , @ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<ResidentialPlot>> findById(@RequestParam int id) {
		return plotService.findById(id);
	}

	@ApiOperation(value = "Get customer By Id",notes = "getting customer object by using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success") , @ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(value = "/{sqFeet}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<ResidentialPlot>>> findAllResidentialPlotBySquareFeet(@PathVariable Double sqFeet) {
		return plotService.findAllResidentialPlotBySquareFeet(sqFeet);
	}

	@ApiOperation(value = "Get customer By Id",notes = "getting customer object by using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success") , @ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(value = "/location/{location}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<Location>>> findByLocation(@PathVariable String location) {
		return plotService.findByLocation(location);
	}

	@ApiOperation(value = "Get customer By Id",notes = "getting customer object by using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success") , @ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(value = "/loc/{location}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<ResidentialPlot>>> filterResidentiaPlotByLocationAndBhk(
			@PathVariable String location,@RequestParam double sqFeet) {
		return plotService.filterResidentiaPlotByLocationAndBhk(location, sqFeet);
	}

	@ApiOperation(value = "Get customer By Id",notes = "getting customer object by using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success") , @ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(value = "/location/{location}/sqFeet/{sqFeet}/type",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<ResidentialPlot>>> filterResidentialPlotByLocationBhkAndType(
			@PathVariable String location,@PathVariable double sqFeet,@RequestParam String type) {
		return plotService.filterResidentialPlotByLocationBhkAndType(location, sqFeet, type);

	}
}
