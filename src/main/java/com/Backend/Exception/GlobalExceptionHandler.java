package com.Backend.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(UserNotFoundException exception, WebRequest request){
		ExceptionResponse response=new ExceptionResponse();
		response.setDatetime(LocalDateTime.now());
		response.setMessage("User Not Found with Given Cradentials!!");
		ResponseEntity<Object> entity=new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
		
		return entity;
	}
	
	
	@ExceptionHandler(RegisterException.class)
	public ResponseEntity<Object> handleException(RegisterException exception, WebRequest request){
		ExceptionResponse response=new ExceptionResponse();
		response.setDatetime(LocalDateTime.now());
		response.setMessage("Something Went Wrong User Cannot be Registered!!");
		ResponseEntity<Object> entity=new ResponseEntity<Object>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	
	@ExceptionHandler(DeleteException.class)
	public ResponseEntity<Object> handleException(DeleteException exception, WebRequest request){
		ExceptionResponse response=new ExceptionResponse();
		response.setDatetime(LocalDateTime.now());
		response.setMessage("Something Went Wrong User Cannot be Deleted!!");
		ResponseEntity<Object> entity=new ResponseEntity<Object>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}

}
