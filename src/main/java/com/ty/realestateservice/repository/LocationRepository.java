package com.ty.realestateservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.realestateservice.dto.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

	public List<Location> findByState(String state);
}
