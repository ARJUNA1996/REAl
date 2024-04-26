package com.ty.realestateservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.realestateservice.dao.ResidentialPlotDao;
import com.ty.realestateservice.dto.Location;
import com.ty.realestateservice.dto.ResidentialPlot;
import com.ty.realestateservice.exception.NoIdFoundException;
import com.ty.realestateservice.util.ResponseStructure;

@Service
public class ResidentialPlotService {

	@Autowired
	ResidentialPlotDao dao;
	
	public ResponseEntity<ResponseStructure<ResidentialPlot>> saveResidentiaPlot(ResidentialPlot plot) {
		ResponseStructure<ResidentialPlot> responseStructure = new ResponseStructure<ResidentialPlot>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully added");
		responseStructure.setData(dao.saveResidentialPlot(plot));
		return new ResponseEntity<ResponseStructure<ResidentialPlot>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<ResidentialPlot>> findById(int id) {
		ResponseStructure<ResidentialPlot> responseStructure = new ResponseStructure<ResidentialPlot>();
		if (dao.findById(id) != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(dao.findById(id));
			return new ResponseEntity<ResponseStructure<ResidentialPlot>>(responseStructure,HttpStatus.OK);
		}else {
			throw new NoIdFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<ResidentialPlot>>> findAllResidentialPlotBySquareFeet(Double sqFeet){
		ResponseStructure<List<ResidentialPlot>> responseStructure = new ResponseStructure<>();
		if (dao.findAllResidentialPlotBySquareFeet(sqFeet) != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(dao.findAllResidentialPlotBySquareFeet(sqFeet));
			return new ResponseEntity<ResponseStructure<List<ResidentialPlot>>>(responseStructure,HttpStatus.OK);
		}else {
			throw new NoIdFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<List<Location>>> findByLocation(String location){
		ResponseStructure<List<Location>> responseStructure = new ResponseStructure<>();
		if (dao.findByLocation(location) != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(dao.findByLocation(location));
			return new ResponseEntity<ResponseStructure<List<Location>>>(responseStructure,HttpStatus.OK);
		}else {
			throw new NoIdFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<ResidentialPlot>>> filterResidentiaPlotByLocationAndBhk(String location, double sqFeet) {
		ResponseStructure<List<ResidentialPlot>> responseStructure = new ResponseStructure<>();
		if (dao.findAllResidentialPlotBySquareFeet(sqFeet) != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(dao.filterResidentialPlotByLocationAndSqFeet(location, sqFeet));
			return new ResponseEntity<ResponseStructure<List<ResidentialPlot>>>(responseStructure,HttpStatus.OK);
		}else {
			throw new NoIdFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<ResidentialPlot>>> filterResidentialPlotByLocationBhkAndType(String location, double sqFeet,String type) {
		ResponseStructure<List<ResidentialPlot>> responseStructure = new ResponseStructure<>();
		if (dao.findAllResidentialPlotBySquareFeet(sqFeet) != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(dao.filterResidentialPlotByLocationBhkAndType(location, sqFeet,type));
			return new ResponseEntity<ResponseStructure<List<ResidentialPlot>>>(responseStructure,HttpStatus.OK);
		}else {
			throw new NoIdFoundException();
		}
	}
}
