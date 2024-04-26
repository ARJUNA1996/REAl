package com.ty.realestateservice.util;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResponseStructure<T> {
	private int status;
	private String message;
	private T Data;
	
	

}
