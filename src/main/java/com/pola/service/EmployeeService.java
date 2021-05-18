package com.pola.service;

import java.util.List;

import com.pola.model.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public void saveEmployee(Employee Employee);

	public Employee getEmployee(int id);

	public void deleteEmployee(int id);
	
}
