package com.one.to.one.mapping.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	private Date timestamp;
	private String message;
	private String details;
	



	
	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	

	public String getMessage() {
		return message;
	}

	

	public String getDetails() {
		return details;
	}
}
