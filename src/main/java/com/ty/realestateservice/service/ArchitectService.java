package com.ty.realestateservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.realestateservice.dao.ArchitectsDao;
import com.ty.realestateservice.dto.Architects;
import com.ty.realestateservice.dto.Builders;
import com.ty.realestateservice.dto.InteriorDesigners;
import com.ty.realestateservice.exception.NoEmailFoundException;
import com.ty.realestateservice.exception.NoIdFoundException;
import com.ty.realestateservice.exception.NoLocationFoundException;
import com.ty.realestateservice.util.ResponseStructure;

@Service
public class ArchitectService {
	@Autowired
	private ArchitectsDao architectsDao;

	public ResponseEntity<ResponseStructure<Architects>> saveArchitects(Architects architects) {
		ResponseStructure<Architects> responseStructure = new ResponseStructure<Architects>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("passed");
		responseStructure.setData(architectsDao.saveArchitects(architects));
		return new ResponseEntity<ResponseStructure<Architects>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Architects>> getArchitectsById(int id) {
		ResponseEntity<ResponseStructure<Architects>> resp;
		Architects architects = architectsDao.getArchitectsById(id);
		ResponseStructure<Architects> responseStructure = new ResponseStructure<Architects>();
		if (architects != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("passed");
			responseStructure.setData(architects);
			resp = new ResponseEntity<ResponseStructure<Architects>>(responseStructure, HttpStatus.OK);
			return resp;
		} else {
			throw new NoIdFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<String>> deleteArchitectsById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (architectsDao.deleteArchitectsById(id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("id deleted");
			responseStructure.setData("architect with given id deleted");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Architects>> findArchitectsByEmail(String email) {
		ResponseEntity<ResponseStructure<Architects>> resp;
		Architects architects = architectsDao.findArchitectsByEmail(email);
		ResponseStructure<Architects> responseStructure = new ResponseStructure<Architects>();
		if (architects != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("passed");
			responseStructure.setData(architects);
			resp = new ResponseEntity<ResponseStructure<Architects>>(responseStructure, HttpStatus.OK);
			return resp;
		} else {
			throw new NoEmailFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Architects>> findArchitectsByLocation(String location) {
		ResponseEntity<ResponseStructure<Architects>> resp;
		Architects architects = architectsDao.findArchitectsByLocation(location);
		ResponseStructure<Architects> responseStructure = new ResponseStructure<Architects>();
		if (architects != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("passed");
			responseStructure.setData(architects);
			resp = new ResponseEntity<ResponseStructure<Architects>>(responseStructure, HttpStatus.OK);
			return resp;
		} else {
			throw new NoLocationFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Architects>> updateArchitects(Architects architects) {
		Architects architects2 = architectsDao.updateArchitects(architects);
		ResponseStructure<Architects> responseStructure = new ResponseStructure<Architects>();
		if (architects2 != null) {
			responseStructure.setMessage("updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(architects2);
			return new ResponseEntity<ResponseStructure<Architects>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("Not found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(architects2);
			return new ResponseEntity<ResponseStructure<Architects>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

}
