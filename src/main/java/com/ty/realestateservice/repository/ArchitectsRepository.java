package com.ty.realestateservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.realestateservice.dto.Architects;

public interface ArchitectsRepository extends JpaRepository<Architects, Integer>{

	Architects findByEmail(String email);

	Architects findByLocation(String location);

}
