package com.reservavehiculos.commons;

import org.springframework.http.HttpStatus;

public class APIResponse {

	private String message;
	private String severity;
	private HttpStatus httpStatus;

	public APIResponse(String message, String severity, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.severity = severity;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
