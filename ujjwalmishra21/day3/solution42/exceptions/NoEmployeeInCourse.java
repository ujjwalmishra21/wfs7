package com.hsbc.day3.solution42.exceptions;

public class NoEmployeeInCourse extends Exception {
	public NoEmployeeInCourse() {
		super();
	}
	
	public NoEmployeeInCourse(String message) {
		super(message);
	}
}
