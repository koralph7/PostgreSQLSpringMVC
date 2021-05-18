package com.pola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pola.model.Employee;
import com.pola.repo.EmployeeDAO;
import com.pola.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		
		
		List<Employee> employees = employeeService.getEmployees();
				
		
		theModel.addAttribute("employees", employees);
		
		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
	
		Employee employee = new Employee();
		
		theModel.addAttribute("employee", employee);
		
		return "employee-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		
		employeeService.saveEmployee(employee);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id,
									Model theModel) {
		
	
		Employee employee = employeeService.getEmployee(id);
		

		theModel.addAttribute("employee", employee);
		
			
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		
	
		employeeService.deleteEmployee(id);
		
		return "redirect:/employee/list";
	}
}










