package com.ty.realestateservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.realestateservice.dto.House;

public interface HouseRepository extends JpaRepository<House, Integer>{

	public List<House> findByBhk(int bhk);
	public List<House> findHouseByLocation(String location);
}
