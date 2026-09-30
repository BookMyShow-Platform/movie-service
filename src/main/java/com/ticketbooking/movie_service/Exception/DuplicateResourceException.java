package com.ticketbooking.movie_service.Exception;

public class DuplicateResourceException extends RuntimeException{
	public DuplicateResourceException(String message) {
		super(message);
	}

}
