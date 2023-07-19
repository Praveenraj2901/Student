package com.example.StudentDetails.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionGlobalHandler {
	@ExceptionHandler(AgeNotEligibleException.class)
	public ResponseEntity<Object> noteligible(AgeNotEligibleException a) {
		return new ResponseEntity<>(a.getMessage(),HttpStatus.NOT_FOUND);
	}

}
