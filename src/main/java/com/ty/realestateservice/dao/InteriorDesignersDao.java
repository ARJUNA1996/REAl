package com.ty.realestateservice.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.realestateservice.dto.InteriorDesigners;
import com.ty.realestateservice.repository.InteriorDesignersRepository;

@Repository
public class InteriorDesignersDao {
	@Autowired
	private InteriorDesignersRepository interiorDesignersRepository;

	public InteriorDesigners saveInteriorDesigners(InteriorDesigners interiorDesigners) {
		return interiorDesignersRepository.save(interiorDesigners);
	}

	public InteriorDesigners getInteriorDesignersById(int id) {
		Optional<InteriorDesigners> optional = interiorDesignersRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public boolean deleteInteriorDesignersById(int id) {
		Optional<InteriorDesigners> optional = interiorDesignersRepository.findById(id);
		if (optional.isPresent()) {
			interiorDesignersRepository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}

	public InteriorDesigners findInteriorDesignersByEmail(String email) {
		InteriorDesigners interiorDesigners = interiorDesignersRepository.getInteriorDesignersByEmail(email);
		if (interiorDesigners != null) {
			return interiorDesigners;
		} else {
			return null;
		}
	}

	public InteriorDesigners findInteriorDesignersByLocation(String location) {
		InteriorDesigners interiorDesigners = interiorDesignersRepository.getInteriorDesignersByLocation(location);
		if (interiorDesigners != null) {
			return interiorDesigners;
		} else {
			return null;
		}
	}

	public InteriorDesigners updateInteriorDesigners(InteriorDesigners interiorDesigners) {
		Optional<InteriorDesigners> optional = interiorDesignersRepository.findById(interiorDesigners.getId());
		if (optional != null) {
			return interiorDesignersRepository.save(interiorDesigners);
		} else {
			return null;
		}
	}

}
