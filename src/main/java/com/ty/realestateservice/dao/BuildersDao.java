package com.ty.realestateservice.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.realestateservice.dto.Builders;
import com.ty.realestateservice.repository.BuildersRepository;

@Repository
public class BuildersDao {
	@Autowired
	private BuildersRepository buildersRepository;

	public Builders saveBuilders(Builders builders) {
		return buildersRepository.save(builders);
	}

	public Builders getBuildersById(int id) {
		Optional<Builders> optional = buildersRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public boolean deleteBuilderById(int id) {
		Optional<Builders> optional = buildersRepository.findById(id);
		if (optional.isPresent()) {
			buildersRepository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}

	public Builders findBuildersByEmail(String email) {
		Builders builders = buildersRepository.findByEmail(email);
		if (builders != null) {
			return builders;
		} else {
			return null;
		}
	}

	public Builders findBuildersByLocation(String location) {
		Builders builders = buildersRepository.findByLocation(location);
		if (builders != null) {
			return builders;
		} else {
			return null;
		}
	}

//	public Builders updateBuilders(Builders builders) {
//		Optional<Builders> optional = buildersRepository.findById(builders.getId());
//		if (optional != null) {
//			return buildersRepository.save(builders);
//		} else {
//			return null;
//		}
//	}

}
