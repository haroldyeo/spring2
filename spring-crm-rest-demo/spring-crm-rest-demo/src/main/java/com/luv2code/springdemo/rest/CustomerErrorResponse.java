package com.luv2code.springdemo.rest;

public class CustomerErrorResponse {
	
	private int status;
	private String message;
	private long timeStammp;
	
	public CustomerErrorResponse() {
	}
	
	public CustomerErrorResponse(int status, String message, long timeStammp) {
		this.status = status;
		this.message = message;
		this.timeStammp = timeStammp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStammp() {
		return timeStammp;
	}
	public void setTimeStammp(long timeStammp) {
		this.timeStammp = timeStammp;
	}
	
	

}
