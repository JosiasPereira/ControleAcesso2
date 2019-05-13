package com.jwtme.Exception;

import org.springframework.http.HttpStatus;

public class GeralException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	public  GeralException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
	public  GeralException(String message) {
		super(message);
		
	}
	
	public HttpStatus getStatus() {
		return this.status;
	}
}
