package com.ty.realestateservice.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String state;
	private String city;
	private String street;
	private String district;
	@OneToOne(mappedBy = "location")
	ResidentialPlot ResidentialPlots;
	@OneToOne(mappedBy = "location")
	private House house;

}
