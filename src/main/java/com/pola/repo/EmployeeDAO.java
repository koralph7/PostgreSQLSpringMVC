package com.pola.repo;

import java.util.List;



import com.pola.model.Employee;

public interface EmployeeDAO {

	
	public List<Employee> getEmployees();

	public void saveEmployee(Employee employee);

	public Employee getEmployee(int id);

	public void deleteEmployee(int id);
	
}
