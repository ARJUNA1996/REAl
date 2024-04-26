package com.ty.realestateservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.realestateservice.dao.BuildersDao;
import com.ty.realestateservice.dto.Builders;
import com.ty.realestateservice.exception.NoEmailFoundException;
import com.ty.realestateservice.exception.NoIdFoundException;
import com.ty.realestateservice.exception.NoLocationFoundException;
import com.ty.realestateservice.util.ResponseStructure;

@Service
public class BuildersService {
	@Autowired
	private BuildersDao buildersDao;

	public ResponseEntity<ResponseStructure<Builders>> saveBuilders(Builders builders) {
		ResponseStructure<Builders> responseStructure = new ResponseStructure<Builders>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("passed");
		responseStructure.setData(buildersDao.saveBuilders(builders));
		return new ResponseEntity<ResponseStructure<Builders>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Builders>> getBuildersById(int id) {
		ResponseEntity<ResponseStructure<Builders>> resp;
		Builders builders = buildersDao.getBuildersById(id);
		ResponseStructure<Builders> responseStructure = new ResponseStructure<Builders>();
		if (builders != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("passed");
			responseStructure.setData(builders);
			resp = new ResponseEntity<ResponseStructure<Builders>>(responseStructure, HttpStatus.OK);
			return resp;
		} else {
			throw new NoIdFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<String>> deleteBuilderById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (buildersDao.deleteBuilderById(id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("id deleted");
			responseStructure.setData("builder with given id deleted");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Builders>> findBuildersByEmail(String email) {
		ResponseEntity<ResponseStructure<Builders>> resp;
		Builders builders = buildersDao.findBuildersByEmail(email);
		ResponseStructure<Builders> responseStructure = new ResponseStructure<Builders>();
		if (builders != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("passed");
			responseStructure.setData(builders);
			resp = new ResponseEntity<ResponseStructure<Builders>>(responseStructure, HttpStatus.OK);
			return resp;
		} else {
			throw new NoEmailFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Builders>> findBuildersByLocation(String location) {
		ResponseEntity<ResponseStructure<Builders>> resp;
		Builders builders = buildersDao.findBuildersByLocation(location);
		ResponseStructure<Builders> responseStructure = new ResponseStructure<Builders>();
		if (builders != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("passed");
			responseStructure.setData(builders);
			resp = new ResponseEntity<ResponseStructure<Builders>>(responseStructure, HttpStatus.OK);
			return resp;
		} else {
			throw new NoLocationFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Builders>> updateBuidlers(Builders builders) {
		ResponseStructure<Builders> responseStructure = new ResponseStructure<Builders>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("passed");
		responseStructure.setData(buildersDao.saveBuilders(builders));
		return new ResponseEntity<ResponseStructure<Builders>>(responseStructure, HttpStatus.OK);
	}

}
