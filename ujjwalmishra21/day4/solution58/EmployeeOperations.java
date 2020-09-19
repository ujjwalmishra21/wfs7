package com.hsbc.day4.solution58;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.hsbc.day4.solution58.exceptions.EmployeeExistsException;
import com.hsbc.day4.solution58.exceptions.InvalidAgeException;

public class EmployeeOperations {
	Map<String, Employee> employees;

	public EmployeeOperations() {
		super();
		this.employees = new HashMap<String, Employee>();
	}
	/*
	 * This function adds new  employees if name and age are valid
	 */
	public String addEmployee(String name, int age) throws EmployeeExistsException, InvalidAgeException {
		if(isNameValid(name) && isAgeValid(age)) {
			Employee employee = new Employee(name, age);
			this.employees.put(name, employee);
			return "Employee successfully added";
		}
		return "Employee cannot be added";
	}
	/*
	 * This functions checks that whether name already exists or not. Return true if name not exist
	 */
	private boolean isNameValid(String name) throws EmployeeExistsException{
		
		if(employees.containsKey(name))
			throw new EmployeeExistsException("Name already exists");
		return true;			
	}
	/*
	 * This functions check whether age is valid or not. Valid Age when 18<=age<=60
	 */
	private boolean isAgeValid(int age) throws InvalidAgeException{
		if(age < 18 || age > 60)
			throw new InvalidAgeException("Age is invalid");
		return true;
	}
	/*
	 * Return employees name set
	 */
	public Set<String> getEmployees(){
		return this.employees.keySet();
	}
}
