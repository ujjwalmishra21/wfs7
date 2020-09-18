package com.hsbc.day3.solution42.dao;

import java.util.Collection;

import com.hsbc.day3.solution42.exceptions.CourseIdExists;
import com.hsbc.day3.solution42.exceptions.CourseNotFound;
import com.hsbc.day3.solution42.exceptions.EmployeeAlreadyExistsInCourse;
import com.hsbc.day3.solution42.exceptions.EmployeeNotFound;
import com.hsbc.day3.solution42.exceptions.NoEmployeeInCourse;
import com.hsbc.day3.solution42.model.Course;
import com.hsbc.day3.solution42.model.Employee;

public interface CourseDAO {
	public Collection<Course> getCourseDetails();
	public Employee registerEmployee(int courseId, Employee employee) throws CourseNotFound, EmployeeAlreadyExistsInCourse;
	public Employee deRegisterEmployee(int courseId, Employee employee) throws CourseNotFound, EmployeeNotFound, NoEmployeeInCourse;
	public Collection<Integer> getEmployees(int courseId) throws CourseNotFound, NoEmployeeInCourse;
	public Course addCourse(Course course) throws CourseIdExists;
}
