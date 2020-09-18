package com.hsbc.day3.solution42.daoimpl;

import java.util.HashMap;
import java.util.Map;

import com.hsbc.day3.solution42.dao.EmployeeDAO;
import com.hsbc.day3.solution42.exceptions.EmployeeExists;
import com.hsbc.day3.solution42.exceptions.EmployeeNotFound;
import com.hsbc.day3.solution42.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
	
	/*
	 * (non-Javadoc)
	 * @see com.hsbc.day3.solution42.dao.EmployeeDAO#addEmployee(com.hsbc.day3.solution42.model.Employee)
	 * Employee object is added to HashMap if not other employee with same
	 * employee id exists
	 */
	@Override
	public Employee addEmployee(Employee employee) throws EmployeeExists {
		if(employees.containsKey(employee.getEmpId())) {
			throw new EmployeeExists("Employee cannot be added");
		}
		employees.put(employee.getEmpId(), employee);
		return employee;
	}
	/*
	 * (non-Javadoc)
	 * @see com.hsbc.day3.solution42.dao.EmployeeDAO#getEmployeeById(int)
	 * Employee object is obtained from Hashmap if exists and returned
	 */
	@Override
	public Employee getEmployeeById(int id) throws EmployeeNotFound {
		Employee employee = employees.get(id);
		if(employee == null){
			throw new EmployeeNotFound("Employee not found");
		}
		return employee;
	}


}
