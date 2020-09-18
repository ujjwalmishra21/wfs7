package com.hsbc.day3.solution42.daoimpl;

import java.util.HashMap;
import java.util.Map;

import com.hsbc.day3.solution42.dao.EmployeeDAO;
import com.hsbc.day3.solution42.exceptions.EmployeeExists;
import com.hsbc.day3.solution42.exceptions.EmployeeNotFound;
import com.hsbc.day3.solution42.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
	
	@Override
	public Employee addEmployee(Employee employee) throws EmployeeExists {
		if(employees.containsKey(employee.getEmpId())) {
			throw new EmployeeExists("Employee cannot be added");
		}
		employees.put(employee.getEmpId(), employee);
		return employee;
	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeNotFound {
		Employee employee = employees.get(id);
		if(employee == null){
			throw new EmployeeNotFound("Employee not found");
		}
		return employee;
	}


}
