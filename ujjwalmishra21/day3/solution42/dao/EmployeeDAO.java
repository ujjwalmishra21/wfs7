package com.hsbc.day3.solution42.dao;

import com.hsbc.day3.solution42.exceptions.EmployeeExists;
import com.hsbc.day3.solution42.exceptions.EmployeeNotFound;
import com.hsbc.day3.solution42.model.Employee;

public interface EmployeeDAO {
	public Employee addEmployee(Employee employee) throws EmployeeExists;
	public Employee getEmployeeById(int id) throws EmployeeNotFound;
}
