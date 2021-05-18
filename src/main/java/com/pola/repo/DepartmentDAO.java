package com.pola.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;

import com.pola.model.Department;
import com.pola.model.Employee;



public interface DepartmentDAO {
	
	public void addDepartment(Department department);
	public Department getDepartment(int id);
	public void deleteDepartment(int id);
	public List<Department> getAllDepartments();
	public List<Department> getDepartments(int employeeId);
	

}
