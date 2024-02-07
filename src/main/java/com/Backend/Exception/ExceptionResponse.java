package com.Backend.Exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
	
	private String message;
	private LocalDateTime datetime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	
	
	

}
