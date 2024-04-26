package com.ty.realestateservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ty.realestateservice.dto.ResidentialPlot;

public interface ResidentialPlotRepository extends JpaRepository<ResidentialPlot, Integer>{

	public List<ResidentialPlot> findByLocation(String location);
	public List<ResidentialPlot> findBySquareFeet(double squareFeet);
}
