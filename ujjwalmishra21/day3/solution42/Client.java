package com.hsbc.day3.solution42;

import java.util.Collection;
import java.util.Scanner;

import com.hsbc.day3.solution42.dao.CourseDAO;
import com.hsbc.day3.solution42.dao.EmployeeDAO;
import com.hsbc.day3.solution42.daoimpl.CourseDAOImpl;
import com.hsbc.day3.solution42.daoimpl.EmployeeDAOImpl;
import com.hsbc.day3.solution42.exceptions.CourseIdExists;
import com.hsbc.day3.solution42.exceptions.CourseNotFound;
import com.hsbc.day3.solution42.exceptions.EmployeeAlreadyExistsInCourse;
import com.hsbc.day3.solution42.exceptions.EmployeeExists;
import com.hsbc.day3.solution42.exceptions.EmployeeNotFound;
import com.hsbc.day3.solution42.exceptions.NoEmployeeInCourse;
import com.hsbc.day3.solution42.model.Course;
import com.hsbc.day3.solution42.model.Employee;

public class Client {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Course course1 = new Course(1, "Java Spring Boot", false, true);
		Course course2 = new Course(2, "Google Cloud Developer", true, true);
		Course course3 = new Course(3, "React FrontEnd", true, false);
		Course course4 = new Course(4, "Angular FrontEnd", false, false);
		Course courses[] = new Course[] {course1, course2, course3, course4};
		
		Employee employee1 = new Employee(1, "Aditya Singh");
		Employee employee2 = new Employee(2, "Kartik Sharma");
		Employee employee3 = new Employee(3, "Ujjwal Mishra");
		Employee employee4 = new Employee(4, "Rajat Kumar");
		Employee employee5 = new Employee(5, "Sachin Chaudhary");
		Employee employees[] = new Employee[] {employee1, employee2, employee3, employee4, employee5};
		
			
		CourseDAO courseDAO = new CourseDAOImpl();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		// Adding courses
		for (Course course: courses)
			try {
				courseDAO.addCourse(course);
			} catch (CourseIdExists e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//Adding employees
		for(Employee employee: employees)
			try {
				employeeDAO.addEmployee(employee);
			} catch (EmployeeExists e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		boolean exit = false;
		while(!exit) {
			System.out.println("Enter the number of the choice you want to choose:");
			System.out.println("1. To register for a course");
			System.out.println("2. To deregister for a course");
			System.out.println("3. To list the courses offered");
			System.out.println("4. To list employees for specific course");
			
			int num = sc.nextInt();
			
			switch(num) {
				case 1:
				try {
					register(courseDAO, employeeDAO);
				} catch (EmployeeNotFound | CourseNotFound | EmployeeAlreadyExistsInCourse e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case 2:
				try {
					deRegister(courseDAO, employeeDAO);
				} catch (EmployeeNotFound | CourseNotFound | NoEmployeeInCourse e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
;					break;
				case 3:
					listCourses(courseDAO);
					break;
				case 4:
				try {
					listEmployeesByCourse(courseDAO, employeeDAO);
				} catch (CourseNotFound | NoEmployeeInCourse | EmployeeNotFound e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				default:
					System.out.println("Exiting......");
					System.out.println();
					exit = true;
					break;
			}
		}
		

	}
	/*
 	Following stages for register:
 	1. Employee inputs employee id
 	2. If employee id valid then courses are listed
 	3. Employee inputs then a course id to be  enrolled.
 	4. If course id valid then user is registered
 */
	
	public static void register(CourseDAO courseDAO, EmployeeDAO employeeDAO) throws EmployeeNotFound, CourseNotFound, EmployeeAlreadyExistsInCourse {
		System.out.println("Enter your Employee ID: ");
		int empId = sc.nextInt();
		System.out.println();
		
		Employee employee = employeeDAO.getEmployeeById(empId);
		
		System.out.println("Enter single Course ID to enroll: ");
		int courseId = sc.nextInt();
		System.out.println();
		
		Employee response = courseDAO.registerEmployee(courseId, employee);
		System.out.println(response + " registered successfully\n");
		
	}
	
	/*
	 		Following stages for de-register:
	 	1. Employee inputs employee id
	 	2. If employee id valid then courses are listed to unenrollment
	 	3. Employee inputs the a course id to de-register.
	 	4. If course id valid then user is de-registered
	 */
	
	public static void deRegister(CourseDAO courseDAO, EmployeeDAO employeeDAO) throws EmployeeNotFound, CourseNotFound, NoEmployeeInCourse {
		System.out.println("Enter your Employee ID: ");
		int empId = sc.nextInt();
		System.out.println();
		
		Employee employee = employeeDAO.getEmployeeById(empId);
		
		System.out.println("Enter Course ID to de-register: ");
		int courseId = sc.nextInt();
		System.out.println();
		
		Employee response = courseDAO.deRegisterEmployee(courseId, employee);
		System.out.println(response + " de-registered successfully\n");
		
	}
	
	public static void listCourses(CourseDAO courseDAO) {
		
		Collection<Course> courses = courseDAO.getCourseDetails();
		
		for (Course course: courses) 
			System.out.println(course);
		
		System.out.println();
		
	}
	/*
	 	Following steps followed to list employees in a course:
	 	1. User inputs course id
	 	2. If course id valid then employee ids for the course are returned
	 	3. Employee ids are mapped to corresponding name and displayed
	 */
	
	public static void listEmployeesByCourse(CourseDAO courseDAO, EmployeeDAO employeeDAO) throws CourseNotFound, NoEmployeeInCourse, EmployeeNotFound {
		System.out.println("Type Course ID to get employees list:");
		int courseId = sc.nextInt();
		
		Collection<Integer> employeesIds = courseDAO.getEmployees(courseId);

		
		for(int empId : employeesIds) {
			System.out.println(employeeDAO.getEmployeeById(empId));
		}
		System.out.println();
	}
}


