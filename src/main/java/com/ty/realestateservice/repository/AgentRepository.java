package com.ty.realestateservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.realestateservice.dto.Agent;

public interface AgentRepository extends JpaRepository<Agent, Integer> {

	public Agent findByName(String name);
	
	
}
