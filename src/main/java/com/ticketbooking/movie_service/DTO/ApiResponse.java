package com.ticketbooking.movie_service.DTO;

public class ApiResponse<T> {
	private String message;
	private T data;
	public ApiResponse() {
		super();
	}
	public ApiResponse(String message, T data) {
		super();
		this.message = message;
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	

}
