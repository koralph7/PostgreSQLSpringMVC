package com.pola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pola.model.Department;
import com.pola.model.Employee;
import com.pola.repo.DepartmentDAO;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentDAO departmentDAO;
	
	@Override
	@Transactional
	public void addDepartment(Department department) {
		departmentDAO.addDepartment(department);
		
	}


	@Override
	public Department getDepartment(int id) {
		return departmentDAO.getDepartment(id);
	}

	@Override
	public void deleteDepartment(int id) {
		departmentDAO.deleteDepartment(id);
		
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentDAO.getAllDepartments();
	}

	@Override
	public List<Department> getDepartments(int employeeId) {
		return departmentDAO.getDepartments(employeeId);
	}

	

}
