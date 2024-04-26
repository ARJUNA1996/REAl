package com.ty.realestateservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.realestateservice.dto.EnqiuryForm;

public interface EnquryRepository extends JpaRepository<EnqiuryForm, Integer>  {

}
