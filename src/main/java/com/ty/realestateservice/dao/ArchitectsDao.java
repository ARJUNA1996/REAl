package com.ty.realestateservice.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.realestateservice.dto.Architects;
import com.ty.realestateservice.repository.ArchitectsRepository;

@Repository
public class ArchitectsDao {

	@Autowired
	private ArchitectsRepository architectsRepository;

	public Architects saveArchitects(Architects architects) {
		return architectsRepository.save(architects);
	}

	public Architects getArchitectsById(int id) {
		Optional<Architects> optional = architectsRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else
			return null;
	}

	public boolean deleteArchitectsById(int id) {
		Optional<Architects> optional = architectsRepository.findById(id);
		if (optional.isPresent()) {
			architectsRepository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}

	public Architects findArchitectsByEmail(String email) {
		Architects architects = architectsRepository.findByEmail(email);
		if (architects != null) {
			return architects;
		} else {
			return null;
		}
	}

	public Architects findArchitectsByLocation(String location) {
		Architects architects = architectsRepository.findByLocation(location);
		if (architects != null) {
			return architects;
		} else {
			return null;
		}
	}

	public Architects updateArchitects(Architects architects) {
		Optional<Architects> optional = architectsRepository.findById(architects.getId());
		if (optional != null) {
			return architectsRepository.save(architects);
		} else {
			return null;
		}
	}

}
