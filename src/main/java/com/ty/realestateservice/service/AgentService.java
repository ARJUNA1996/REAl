package com.ty.realestateservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.realestateservice.dao.AgentDao;
import com.ty.realestateservice.dto.Agent;
import com.ty.realestateservice.dto.House;
import com.ty.realestateservice.dto.ResidentialPlot;
import com.ty.realestateservice.exception.NoIdFoundException;
import com.ty.realestateservice.exception.NoNameFoundException;
import com.ty.realestateservice.util.ResponseStructure;

@Service
public class AgentService {

	@Autowired
	private AgentDao agentDao;

	public ResponseEntity<ResponseStructure<Agent>> saveAgent(Agent agent) {
		ResponseStructure<Agent> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucess");
		responseStructure.setData(agentDao.saveAgent(agent));
		return new ResponseEntity<ResponseStructure<Agent>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Agent>> getAgentById(int id) {
		Agent agent = agentDao.getAgentById(id);
		if (agent != null) {
			ResponseStructure<Agent> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("sucess");
			responseStructure.setData(agent);
			return new ResponseEntity<ResponseStructure<Agent>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("id:" + id + ",not found ");
		}

	}

	public ResponseEntity<ResponseStructure<List<Agent>>> getAllAgent() {
		ResponseStructure<List<Agent>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("sucess");
		responseStructure.setData(agentDao.getAllAgent());
		return new ResponseEntity<ResponseStructure<List<Agent>>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<String>> deleteAgentById(int id) {
		if (agentDao.deleteAgentById(id)) {
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("sucess");
			responseStructure.setData("id: " + id + " object has been deleted");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("id: " + id + ",not found");
		}
	}

	public ResponseEntity<ResponseStructure<Agent>> getAgentByName(String name) {
		if (agentDao.getAgentByName(name) != null) {
			ResponseStructure<Agent> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("sucess");
			responseStructure.setData(agentDao.getAgentByName(name));
			return new ResponseEntity<ResponseStructure<Agent>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoNameFoundException("name:" + name + " ,not found ");
		}

	}

	public ResponseEntity<ResponseStructure<Agent>> updateAgent(Agent agent) {
		ResponseStructure<Agent> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("sucess");
		responseStructure.setData(agentDao.saveAgent(agent));
		return new ResponseEntity<ResponseStructure<Agent>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<List<House>>> getAgentHousesList(String name) {
		if (agentDao.getAgentHousesList(name).isEmpty()) {
			throw new NoNameFoundException("name:" + name + " ,not found ");
		} else {
			ResponseStructure<List<House>> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("sucess");
			responseStructure.setData(agentDao.getAgentHousesList(name));
			return new ResponseEntity<ResponseStructure<List<House>>>(responseStructure, HttpStatus.OK);
		}
	}
 
	public ResponseEntity<ResponseStructure<List<ResidentialPlot>>> getAgentResedentialPlotList(String name) {
		if (agentDao.getAgentResedentialPlotList(name).isEmpty()) {
			throw new NoNameFoundException("name:" + name + " ,not found ");
		} else {
			ResponseStructure<List<ResidentialPlot>> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("sucess");
			responseStructure.setData(agentDao.getAgentResedentialPlotList(name));
			return new ResponseEntity<ResponseStructure<List<ResidentialPlot>>>(responseStructure, HttpStatus.OK);
		}
	}

}
