package com.ty.realestateservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.realestateservice.dao.InteriorDesignersDao;
import com.ty.realestateservice.dto.InteriorDesigners;
import com.ty.realestateservice.exception.NoEmailFoundException;
import com.ty.realestateservice.exception.NoIdFoundException;
import com.ty.realestateservice.exception.NoLocationFoundException;
import com.ty.realestateservice.util.ResponseStructure;

@Service
public class InteriorDesignersService {
	@Autowired
	private InteriorDesignersDao interiorDesignersDao;

	public ResponseEntity<ResponseStructure<InteriorDesigners>> saveInteriorDesigners(
			InteriorDesigners interiorDesigners) {
		ResponseStructure<InteriorDesigners> responseStructure = new ResponseStructure<InteriorDesigners>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("passed");
		responseStructure.setData(interiorDesignersDao.saveInteriorDesigners(interiorDesigners));
		return new ResponseEntity<ResponseStructure<InteriorDesigners>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<InteriorDesigners>> getInteriorDesignersById(int id) {
		ResponseEntity<ResponseStructure<InteriorDesigners>> resp;
		InteriorDesigners interiorDesigners = interiorDesignersDao.getInteriorDesignersById(id);
		ResponseStructure<InteriorDesigners> responseStructure = new ResponseStructure<InteriorDesigners>();
		if (interiorDesigners != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("passed");
			responseStructure.setData(interiorDesigners);
			resp = new ResponseEntity<ResponseStructure<InteriorDesigners>>(responseStructure, HttpStatus.OK);
			return resp;
		} else {
			throw new NoIdFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<String>> deleteInteriorDesignersById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (interiorDesignersDao.deleteInteriorDesignersById(id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("id deleted");
			responseStructure.setData("interior designers with given id deleted");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<InteriorDesigners>> findInteriorDesignersByEmail(String email) {
		ResponseEntity<ResponseStructure<InteriorDesigners>> resp;
		InteriorDesigners interiorDesigners = interiorDesignersDao.findInteriorDesignersByEmail(email);
		ResponseStructure<InteriorDesigners> responseStructure = new ResponseStructure<InteriorDesigners>();
		if (interiorDesigners != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("passed");
			responseStructure.setData(interiorDesigners);
			resp = new ResponseEntity<ResponseStructure<InteriorDesigners>>(responseStructure, HttpStatus.OK);
			return resp;
		} else {
			throw new NoEmailFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<InteriorDesigners>> findInteriorDesignersByLocation(String location) {
		ResponseEntity<ResponseStructure<InteriorDesigners>> resp;
		InteriorDesigners interiorDesigners = interiorDesignersDao.findInteriorDesignersByEmail(location);
		ResponseStructure<InteriorDesigners> responseStructure = new ResponseStructure<InteriorDesigners>();
		if (interiorDesigners != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("passed");
			responseStructure.setData(interiorDesigners);
			resp = new ResponseEntity<ResponseStructure<InteriorDesigners>>(responseStructure, HttpStatus.OK);
			return resp;
		} else {
			throw new NoLocationFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<InteriorDesigners>> updateInteriorDesigners(
			InteriorDesigners interiorDesigners) {
		InteriorDesigners interiorDesigners2 = interiorDesignersDao.updateInteriorDesigners(interiorDesigners);
		ResponseStructure<InteriorDesigners> responseStructure = new ResponseStructure<InteriorDesigners>();
		if (interiorDesigners2 != null) {
			responseStructure.setMessage("updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(interiorDesigners2);
			return new ResponseEntity<ResponseStructure<InteriorDesigners>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("Not found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(interiorDesigners2);
			return new ResponseEntity<ResponseStructure<InteriorDesigners>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

}
