package com.ty.realestateservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.realestateservice.dao.HouseDao;
import com.ty.realestateservice.dto.House;
import com.ty.realestateservice.dto.Location;
import com.ty.realestateservice.util.ResponseStructure;

@Service
public class HouseService {

	@Autowired
	HouseDao dao;
	
	public ResponseEntity<ResponseStructure<House>> saveHouse(House house) {
		ResponseStructure<House> responseStructure = new ResponseStructure<House>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully added");
		responseStructure.setData(dao.saveHouse(house));
		return new ResponseEntity<ResponseStructure<House>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<House>> findById(int id) {
		ResponseStructure<House> responseStructure = new ResponseStructure<>();
		if (dao.findById(id) != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(dao.findById(id));
			return new ResponseEntity<ResponseStructure<House>>(responseStructure,HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<List<House>>> findAllHouseByBhk(int bhk) {
		ResponseStructure<List<House>> responseStructure = new ResponseStructure<>();
		if (dao.findAllHouseByBhk(bhk) != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(dao.findAllHouseByBhk(bhk));
			return new ResponseEntity<ResponseStructure<List<House>>>(responseStructure,HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Location>>> findByLocation(String location) {
		ResponseStructure<List<Location>> responseStructure = new ResponseStructure<>();
		if (dao.findByLocation(location) != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(dao.findByLocation(location));
			return new ResponseEntity<ResponseStructure<List<Location>>>(responseStructure,HttpStatus.OK);
		}else {
			return null;
		}
	}
}
