package com.hsbc.day4.solution58.exceptions;

@SuppressWarnings("serial")
public class EmployeeExistsException extends Exception {
	
	public EmployeeExistsException() {
		super();
	}
	public EmployeeExistsException(String message) {
		super(message);
	}

}
