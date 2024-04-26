package com.ty.realestateservice.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.realestateservice.dto.House;
import com.ty.realestateservice.dto.Location;
import com.ty.realestateservice.repository.HouseRepository;
import com.ty.realestateservice.repository.LocationRepository;

@Repository
public class HouseDao {

	@Autowired
	HouseRepository repository;
	
	@Autowired
	LocationRepository locationRepository;

	public House saveHouse(House house) {
		return repository.save(house);
	}

	public House findById(int id) {
		Optional<House> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public boolean deleteHouseById(int id) {
		Optional<House> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

	public List<House> findAllHouseByBhk(int bhk) {
		List<House> houses = repository.findByBhk(bhk);

		if (houses.isEmpty()) {
			return null;
		} else {
			return houses;
		}
	}

	public List<Location> findByLocation(String location) {
		List<Location> houses = locationRepository.findByState(location);

		if (houses.isEmpty()) {
			return null;
		} else {
			return houses;
		}
	}

	public List<House> filterHouseByLocationAndBhk(String location, int bhk) {

		List<House> houses = repository.findHouseByLocation(location);
		List<House> houses2 = new ArrayList<>();
		for (House house : houses) {
			if (house.getBhk() == bhk) {
				houses2.add(house);
			}
		}
		return houses2;
	}

	public List<House> filterHouseByLocationBhkAndHouseType(String location, int bhk,String houseType) {

		List<House> houses = repository.findHouseByLocation(location);
		List<House> houses2 = new ArrayList<>();
		for (House house : houses) {
			if (house.getBhk() == bhk && house.getHouseType() == houseType) {
				houses2.add(house);
			}
		}
		return houses2;
	}
	
	
}
