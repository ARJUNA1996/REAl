package com.ty.realestateservice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.realestateservice.dto.Location;
import com.ty.realestateservice.dto.ResidentialPlot;
import com.ty.realestateservice.repository.LocationRepository;
import com.ty.realestateservice.repository.ResidentialPlotRepository;

@Repository
public class ResidentialPlotDao {

	@Autowired
	ResidentialPlotRepository repository;
	@Autowired
	LocationRepository locationRepository;
	
	public ResidentialPlot saveResidentialPlot(ResidentialPlot plot) {
		return repository.save(plot);
	}
	
	public ResidentialPlot findById(int id) {
		Optional<ResidentialPlot> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public boolean deleteHouseById(int id) {
		Optional<ResidentialPlot> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
	public List<ResidentialPlot> findAllResidentialPlotBySquareFeet(Double sqFeet) {
		List<ResidentialPlot> houses = repository.findBySquareFeet(sqFeet);

		if (houses.isEmpty()) {
			return null;
		} else {
			return houses;
		}
	}
	
	public List<Location> findByLocation(String location) {
		List<Location> locations = locationRepository.findByState(location);

		if (locations.isEmpty()) {
			return null;
		} else {
			return locations;
		}
	}
	
	public List<ResidentialPlot> filterResidentialPlotByLocationAndSqFeet(String location, double sqFeet) {

		List<ResidentialPlot> plot = repository.findByLocation(location);
		List<ResidentialPlot> plots = new ArrayList<>();
		for (ResidentialPlot plot1 : plot) {
			if (plot1.getSquareFeet() == sqFeet) {
				plots.add(plot1);
			}
		}
		return plots;
	}
	
	public List<ResidentialPlot> filterResidentialPlotByLocationBhkAndType(String location, double sqFeet,String type) {

		List<ResidentialPlot> plot = repository.findByLocation(location);
		List<ResidentialPlot> plots = new ArrayList<>();
		for (ResidentialPlot resPlot : plot) {
			if (resPlot.getSquareFeet() == sqFeet && resPlot.getType() == type) {
				plots.add(resPlot);
			}
		}
		return plots;
	}
}
