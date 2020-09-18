package com.hsbc.day3.solution42.model;

import java.util.Set;

public class Course {
	int courseId;
	String courseName;
	boolean isFullTime;
	boolean isOffline;
	Set<Integer> employees;
	
	public Course() {
		super();
	}
	
	public Course(int courseId, String courseName, boolean isFullTime, boolean isOffline) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.isFullTime = isFullTime;
		this.isOffline = isOffline;
	}

	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public boolean isFullTime() {
		return isFullTime;
	}
	public void setFullTime(boolean isFullTime) {
		this.isFullTime = isFullTime;
	}
	
	public boolean isOffline() {
		return isOffline;
	}

	public void setOffline(boolean isOffline) {
		this.isOffline = isOffline;
	}

	public Set<Integer> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Integer> employees) {
		this.employees = employees;
	}
	
	@Override
	public String toString() {
		String type = this.isFullTime ? "Full Time" : "Part Time";
		String location = this.isOffline ? "Offline" : "Online";
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", type=" + type + ", place="+ location +"]";
	}
	
	
}
