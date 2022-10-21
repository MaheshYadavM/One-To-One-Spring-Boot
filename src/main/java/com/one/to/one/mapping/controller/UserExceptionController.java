package com.one.to.one.mapping.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.one.to.one.mapping.exception.UserNotFoundException;


@ControllerAdvice
public class UserExceptionController {

	@ExceptionHandler(value =UserNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(UserNotFoundException exception ,WebRequest request){
		UserNotFoundException re=new UserNotFoundException(new Date(),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity(re,HttpStatus.NOT_FOUND);
		
	}
}
