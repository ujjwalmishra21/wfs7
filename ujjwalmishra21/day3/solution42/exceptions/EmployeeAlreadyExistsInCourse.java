package com.hsbc.day3.solution42.exceptions;

public class EmployeeAlreadyExistsInCourse extends Exception {
	public EmployeeAlreadyExistsInCourse() {
		super();
	}
	
	public EmployeeAlreadyExistsInCourse(String message) {
		super(message);
	}
}
