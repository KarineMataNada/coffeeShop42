package com.coffeeshop42.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.coffeeshop42.exception.ResourceBadRequestException;
import com.coffeeshop42.exception.ResourceNotFoundException;
import com.coffeeshop42.exception.error.ErrorMessage;


@ControllerAdvice
public class ApiHandleException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException exception){
		ErrorMessage errorMessage = new ErrorMessage(
				"Not Found",
				HttpStatus.NOT_FOUND.value(),
				exception.getMessage(),
				exception.getClass().getName(),
				new Date().getTime());
		
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ResourceBadRequestException.class)
	public ResponseEntity<?> handlerResourceBadRequestException(ResourceBadRequestException exception){
		ErrorMessage errorMessage = new ErrorMessage(
				"Bad Request",
				HttpStatus.BAD_REQUEST.value(),
				exception.getMessage(),
				exception.getClass().getName(),
				new Date().getTime());
		
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		
	}
}
