package com.gaurav.exceptions;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {
	@ExceptionHandler(EmployeeException.class)
	public static ResponseEntity<ErrorClass> employeeException(EmployeeException e) {
		ErrorClass ec = new ErrorClass();
		ec.setMessage(e.getMessage());
		ec.setError(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ErrorClass>(ec, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public static ResponseEntity<?> normalException(Exception e) {
		ErrorClass ec = new ErrorClass();
		ec.setMessage(e.getMessage());
		ec.setError(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ErrorClass>(ec, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public static ResponseEntity<ErrorClass> messageNotFoundException(MethodArgumentNotValidException ex) {
		ErrorClass ec = new ErrorClass();
		String collect = ex.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.joining(","));
		ec.setMessage(collect);
		ec.setError(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ErrorClass>(ec, HttpStatus.BAD_REQUEST);

	}

}
