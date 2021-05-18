package com.pola.service;

import java.util.List;

import com.pola.model.Department;
import com.pola.model.Employee;

public interface DepartmentService {
	
	public void addDepartment(Department department);
	public Department getDepartment(int id);
	public void deleteDepartment(int id);
	public List<Department> getAllDepartments();
	public List<Department> getDepartments(int employeeId);
	

}
