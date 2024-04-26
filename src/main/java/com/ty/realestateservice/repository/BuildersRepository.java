package com.ty.realestateservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.realestateservice.dto.Builders;

public interface BuildersRepository  extends JpaRepository<Builders,Integer>{

	Builders findByEmail(String email);

	Builders findByLocation(String location);

}
