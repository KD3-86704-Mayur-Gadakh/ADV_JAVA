package com.ecom.cutome_exception;

public class ResourceNotFoundException extends RuntimeException {

	
	public ResourceNotFoundException(String mesg) {
		super(mesg);
	}
	
}
