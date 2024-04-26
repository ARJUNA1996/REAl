package com.ty.realestateservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.realestateservice.dto.InteriorDesigners;

public interface InteriorDesignersRepository extends JpaRepository<InteriorDesigners, Integer>{

	InteriorDesigners getInteriorDesignersByEmail(String email);

	InteriorDesigners getInteriorDesignersByLocation(String location);

	

}
