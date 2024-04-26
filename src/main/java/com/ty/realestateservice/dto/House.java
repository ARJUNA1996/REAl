package com.ty.realestateservice.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class House {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String houseType;
	private double squareFeet;
	private double bookingAmount;
	private int bhk;
	private double totalCost;
	private String purpose;
	@OneToOne(cascade = CascadeType.ALL)
	private Contact contact;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Location location;
}
