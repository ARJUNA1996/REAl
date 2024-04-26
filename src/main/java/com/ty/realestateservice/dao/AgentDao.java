package com.ty.realestateservice.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.realestateservice.dto.Agent;
import com.ty.realestateservice.dto.House;
import com.ty.realestateservice.dto.ResidentialPlot;
import com.ty.realestateservice.repository.AgentRepository;

@Repository
public class AgentDao {

	@Autowired
	private AgentRepository agentRepository;

	public Agent saveAgent(Agent agent) {
		return agentRepository.save(agent);
	}

	public Agent getAgentById(int id) {
		Optional<Agent> optional = agentRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public List<Agent> getAllAgent() {
		return agentRepository.findAll();
	}

	public boolean deleteAgentById(int id) {
		Optional<Agent> optional = agentRepository.findById(id);
		if (optional.isPresent()) {
			agentRepository.delete(optional.get());
			return true;

		} else {
			return false;
		}
	}

	public Agent getAgentByName(String name) {
		Agent agent = agentRepository.findByName(name);

		if (agent != null) {
			return agent;
		}
		return null;
	}

	public List<House> getAgentHousesList(String name) {
		if (getAgentByName(name) != null) {
			return getAgentByName(name).getHouses();
		}
		return null;
	}

	public List<ResidentialPlot> getAgentResedentialPlotList(String name) {
		if (getAgentByName(name) != null) {
			return getAgentByName(name).getResidentialPlots();
		}
		return null;
	}

}
