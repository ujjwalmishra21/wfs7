package com.hsbc.day3.solution42.exceptions;

public class CourseIdExists extends Exception {
	
	public CourseIdExists() {
		super();
	}
	
	public CourseIdExists(String message) {
		super(message);
	}
}
