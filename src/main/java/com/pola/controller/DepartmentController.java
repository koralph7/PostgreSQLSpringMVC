package com.pola.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pola.model.Department;
import com.pola.model.Employee;
import com.pola.service.DepartmentService;
import com.pola.service.EmployeeService;

@Controller
@RequestMapping("employee/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	EmployeeService empServ;
	
	@GetMapping("/list")
	public String listDepartment(Model theModel) {
		
		
		List<Department> departments = departmentService.getAllDepartments();
				
		
		theModel.addAttribute("departments", departments);
		
		return "list-departments";
	}
	
	@GetMapping("/listById")
	public String listEmployeeDepartments(@RequestParam("employeeId") int id, Model theModel) {
		
		
		List<Department> departments = departmentService.getDepartments(id);
				
		
		theModel.addAttribute("departments", departments);
		
		return "list-departmentsById";
	}
	
	@GetMapping("/showFormForAddDep")
	public String showFormForAdd(Model theModel) {
		
	
		Department department = new Department();
		
		
		
		theModel.addAttribute("department", department);
		
		return "department-form";
	}
	
	@PostMapping("/saveDepartment")
	public String saveDepartment(@ModelAttribute("department") Department department, final HttpServletRequest request, Model model) {
		
		int empId = department.getEmployee().getId();
		
		Employee employee = empServ.getEmployee(empId);
		
		if (employee == null) {
			
			 model.addAttribute("error", "Selected Employee doesn't exist");
		        return "department-form";
			
		}
		
		departmentService.addDepartment(department);
		
		
		return "redirect:/employee/department/list";
	}
	
	@GetMapping("/showFormForUpdateDep")
	public String showFormForUpdateDep(@RequestParam("departmentId") int id,
									Model theModel) {
		
		Department department = departmentService.getDepartment(id);
		
		
		

		theModel.addAttribute("department", department);
		
			
		return "department-form";
	}

	@GetMapping("/delete")
	public String deleteDepartment(@RequestParam("departmentId") int id) {
		
		departmentService.deleteDepartment(id);
		
		
		return "redirect:/employee/department/list";
	}
}
