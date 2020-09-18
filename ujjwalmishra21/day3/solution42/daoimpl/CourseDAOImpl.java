package com.hsbc.day3.solution42.daoimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.hsbc.day3.solution42.dao.CourseDAO;
import com.hsbc.day3.solution42.exceptions.CourseIdExists;
import com.hsbc.day3.solution42.exceptions.CourseNotFound;
import com.hsbc.day3.solution42.exceptions.EmployeeAlreadyExistsInCourse;
import com.hsbc.day3.solution42.exceptions.EmployeeNotFound;
import com.hsbc.day3.solution42.exceptions.NoEmployeeInCourse;
import com.hsbc.day3.solution42.model.Course;
import com.hsbc.day3.solution42.model.Employee;

public class CourseDAOImpl implements CourseDAO{
	
	private Map<Integer, Course> courses = new HashMap<Integer, Course>();
	
	@Override
	public Collection<Course> getCourseDetails() {
		return courses.values();
	}

	@Override
	public Employee registerEmployee(int courseId, Employee employee) throws CourseNotFound, EmployeeAlreadyExistsInCourse {
		Course course = courses.get(courseId);
		if(course == null) {
			throw new CourseNotFound("Course not found");
		}
		Set<Integer> employees = course.getEmployees();
		if(employees == null)
			employees = new HashSet<Integer>();
		if(employees.contains(employee.getEmpId())) {
			throw new EmployeeAlreadyExistsInCourse("Employee cannot be registered for course");
		}
		employees.add(employee.getEmpId());
		course.setEmployees(employees);
		return employee;
	}

	@Override
	public Employee deRegisterEmployee(int courseId, Employee employee) throws CourseNotFound, EmployeeNotFound, NoEmployeeInCourse {
		Course course = courses.get(courseId);
		if(course == null) {
			throw new CourseNotFound("Course not found");
		}
		Set<Integer> employees = course.getEmployees();
		if(employees == null) {
			throw new NoEmployeeInCourse("Employee not found in course");
		}
		if(!employees.contains(employee.getEmpId())) {
			throw new EmployeeNotFound("Employee not found");
		}
		
		employees.remove(employee.getEmpId());
		course.setEmployees(employees);
		return employee;
	}

	@Override
	public Collection<Integer> getEmployees(int courseId) throws CourseNotFound, NoEmployeeInCourse {
		Course course = courses.get(courseId);
		if(course == null) {
			throw new CourseNotFound("Course not found");
		}
		Set<Integer> employees = course.getEmployees();
		if(employees == null || employees.size() == 0) {
			throw new NoEmployeeInCourse("No employee found in course");
		}
		return new ArrayList<Integer>(employees);
	}

	@Override
	public Course addCourse(Course course) throws CourseIdExists{
		if(courses.containsKey(course.getCourseId())) {
			throw new CourseIdExists("Course Id exists");
		}
		courses.put(course.getCourseId(), course);
		return course;
	}

}
