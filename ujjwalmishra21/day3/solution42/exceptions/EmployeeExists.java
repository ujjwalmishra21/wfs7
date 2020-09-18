package com.hsbc.day3.solution42.exceptions;

public class EmployeeExists extends Exception {
	public EmployeeExists() {
		super();
	}
	
	public EmployeeExists(String message) {
		super(message);
	}
}
