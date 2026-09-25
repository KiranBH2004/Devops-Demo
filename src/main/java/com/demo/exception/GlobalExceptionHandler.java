package com.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException e) {
		
		ErrorResponse error = new ErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatuscode(HttpStatus.NOT_FOUND.value());
		error.setTime(LocalDateTime.now());
		
		return new ResponseEntity(error , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		
		ErrorResponse error = new ErrorResponse();
		error.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
		error.setStatuscode(HttpStatus.NOT_FOUND.value());
		error.setTime(LocalDateTime.now());
		
		return new ResponseEntity(error , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
		
		ErrorResponse error = new ErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatuscode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setTime(LocalDateTime.now());
		
		ResponseEntity<ErrorResponse> rs = new ResponseEntity(error , HttpStatus.INTERNAL_SERVER_ERROR);
		
		return rs;
	}

}
