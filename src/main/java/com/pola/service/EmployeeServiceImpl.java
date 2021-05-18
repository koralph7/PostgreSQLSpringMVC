package com.pola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pola.model.Employee;
import com.pola.repo.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {

		employeeDAO.saveEmployee(employee);
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		
		return employeeDAO.getEmployee(id);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		
		employeeDAO.deleteEmployee(id);
	}
}





