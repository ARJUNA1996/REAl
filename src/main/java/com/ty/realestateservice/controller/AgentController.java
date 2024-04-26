package com.ty.realestateservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.ty.realestateservice.dto.Agent;
import com.ty.realestateservice.dto.House;
import com.ty.realestateservice.dto.ResidentialPlot;
import com.ty.realestateservice.exception.NoIdFoundException;
import com.ty.realestateservice.exception.NoNameFoundException;
import com.ty.realestateservice.service.AgentService;
import com.ty.realestateservice.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/agents")
public class AgentController {
	@Autowired
	private AgentService agentService;

	@ApiOperation(value = "save agent", notes = "input is agent object and returns object with generated id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully saved"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Agent>> saveAgent(@RequestBody Agent agent) {
		return agentService.saveAgent(agent);

	}

	@ApiOperation(value = "fetch agent", notes = "input is agent id and returns object with given id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@GetMapping(value = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE }) 
	public ResponseEntity<ResponseStructure<Agent>> getAgentById(@PathVariable int id) {
		return agentService.getAgentById(id);

	}

	@ApiOperation(value = "fetch  all agent", notes = "returns all agents data")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@GetMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<Agent>>> getAllAgent() {
		return agentService.getAllAgent();

	}

	@ApiOperation(value = "remove agent object by Id", notes = "input agent  id returns message object is deleted or not")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@DeleteMapping(value = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE }) 
	public ResponseEntity<ResponseStructure<String>> deleteAgentById(@PathVariable int id) {
		return agentService.deleteAgentById(id);
	}

	@ApiOperation(value = "fetch agent by name", notes = "input is agent name and returns object with given name")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@GetMapping(value = "/{name}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Agent>> getAgentByName(@PathVariable String name) {
		return agentService.getAgentByName(name); 

	}

	@ApiOperation(value = "fetch agent", notes = "input is agent id and returns object with given id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Agent>> updateAgent(@RequestBody Agent agent) {
		return agentService.updateAgent(agent);
	}

	@ApiOperation(value = "fetch agents houses list by name", notes = "returns  agents houses data")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@GetMapping(value = "/houses/{name}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<House>>> getAgentHousesList(@PathVariable String name) {
		return agentService.getAgentHousesList(name);
	}

	@ApiOperation(value = "fetch residential plots list by name", notes = "returns  agents plots data")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully fetched"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@GetMapping(value = "/resedentialplots/{name}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<ResidentialPlot>>> getAgentResedentialPlotList(
			@PathVariable String name) {
		return agentService.getAgentResedentialPlotList(name);
	}

}
