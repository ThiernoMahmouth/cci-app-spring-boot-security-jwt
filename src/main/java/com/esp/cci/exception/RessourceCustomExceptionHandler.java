package com.esp.cci.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.esp.cci.util.MethodUtils;

@ControllerAdvice
public class RessourceCustomExceptionHandler 
{
	@ExceptionHandler(value=ApplicationException.class)
	public ResponseEntity<Map<String, String>> applicationException(ApplicationException exception)
	{
		HttpStatus status= HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(MethodUtils.prepareErrorJSON(status, exception), status);
	}
	
	@ExceptionHandler(value= RessourceNotFoundException.class)
	public ResponseEntity<Map<String, String>> ressourceNotFounfException(RessourceNotFoundException exception)
	{
		HttpStatus status=HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(MethodUtils.prepareErrorJSON(status, exception), status);
	}
}
