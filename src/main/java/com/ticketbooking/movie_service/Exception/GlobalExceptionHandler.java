package com.ticketbooking.movie_service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ticketbooking.movie_service.DTO.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<Object>> HandleResourceNotFound(ResourceNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(ex.getMessage(), null));
	}
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<ApiResponse<Object>> HandleDuplicateResource(DuplicateResourceException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse<>(ex.getMessage(), null));
	}
}
