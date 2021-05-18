package com.pola.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pola.model.Department;
import com.pola.model.Employee;
import com.pola.service.DepartmentService;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Autowired
	DepartmentService departmentService;
			
	@Override
	public List<Employee> getEmployees() {
		
	
		
		
		// PostgreSQL syntax = Select * from Employee order by last_name;
		
		Query<Employee> theQuery = 
				getCurrentSession().createQuery("from Employee order by lastName",
											Employee.class);
		
		
		List<Employee> employees = theQuery.getResultList();
				
				
		return employees;
	}

	@Override
	public void saveEmployee(Employee employee) {

		// e. x. PostgreSQL synthax = Insert into Employee(name, last_name, position, salary)
		//values ('Marcin','Grochowski', 'Konserwator', 3000);
		
		//or update 
		
		// e. x. PostgreSQL synthax = Update Employee SET last_name = 'Herka' Where id = 15;
		
		
		getCurrentSession().saveOrUpdate(employee);
		
	}

	@Override
	public Employee getEmployee(int id) {

		// e. x. PostgreSQL synthax = Select from Employee where Employee.id = 15;
		
		
		
		
		Employee employee = getCurrentSession().get(Employee.class, id);
		
		return employee;
	}

	@Override
	public void deleteEmployee(int id) {

		
		//e. x. PostgreSQL synthax = Delete from Employee where id = 16;
		
		
		List<Department> depByEmployee = departmentService.getDepartments(id);
		
		
		
		System.out.println(depByEmployee.size() + "długość listy");
		if (depByEmployee.size() != 0) {
			
			for(Department department: depByEmployee) 
			{
				department.setEmployee(null);
				departmentService.addDepartment(department);
			}
			
		}
		
		for (Department department : depByEmployee) {
			
			System.out.println("employye to " + department.getEmployee());
		}
		
	
		
		
		Query theQuery = 
				getCurrentSession().createQuery("delete from Employee where id=:id");
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();		
	}



}











