package com.hsbc.day4.solution58;

import java.util.Set;

import com.hsbc.day4.solution58.exceptions.EmployeeExistsException;
import com.hsbc.day4.solution58.exceptions.InvalidAgeException;
/*
 * Program shows usage of user-defined exceptions.
 * The programs added Employees with name and age.
 * It generats a custom defined exception when the user enters an employee name 
that has been already entered and raise another exception if the age is negative or less
than 18 or greater than 60
 */
public class Client {

	public static void main(String[] args) {
		
		EmployeeOperations operation = new EmployeeOperations();
		
		try {
			String response = operation.addEmployee("Aditya", 23);
			System.out.println("Response: " + response);
		} catch (EmployeeExistsException | InvalidAgeException e) {
			e.printStackTrace();
		}
				
		try {
			String response = operation.addEmployee("Aarav", 24);
			System.out.println("Response: " + response);
		} catch (EmployeeExistsException | InvalidAgeException e) {
			e.printStackTrace();
		}
		
		try {
			String response = operation.addEmployee("Aarav", 22);
			System.out.println("Response: " + response);
		} catch (EmployeeExistsException | InvalidAgeException e) {
			e.printStackTrace();
		}
		
		try {
			String response = operation.addEmployee("Chetan", 23);
			System.out.println("Response: " + response);
		} catch (EmployeeExistsException | InvalidAgeException e) {
			e.printStackTrace();
		}
		
		try {
			String response = operation.addEmployee("Mike", 28);
			System.out.println("Response: " + response);
		} catch (EmployeeExistsException | InvalidAgeException e) {
			e.printStackTrace();
		}	
		
		try {
			String response = operation.addEmployee("Nishant", 67);
			System.out.println("Response: " + response);
		} catch (EmployeeExistsException | InvalidAgeException e) {
			e.printStackTrace();
		}	
		
		Set<String> employees = operation.getEmployees();
		System.out.println("Employees: ");
		for(String name: employees) {
			System.out.println(name);
		}
		
	}

}
