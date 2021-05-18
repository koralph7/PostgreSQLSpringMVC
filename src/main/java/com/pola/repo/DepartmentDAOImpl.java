package com.pola.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pola.model.Department;
import com.pola.model.Employee;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional
	public void addDepartment(Department department) {
		
		//Insert into Department (name, employee_id) values ('Magazyn', 14);
		// or update
		//Update Department Set employee_id = 14 Where id = 18;

		getCurrentSession().saveOrUpdate(department);
		getCurrentSession().flush();
		
	}

	

	@Override
	@Transactional
	public Department getDepartment(int id) {
		
		//Select * from Department where id = 19;

		Department department = getCurrentSession().get(Department.class, id);
		
		return department;
	}

	@Override
	@Transactional
	public void deleteDepartment(int id) {
		
		//Delete from Department where id = 20;

		
		Department department = getDepartment(id);
		
			getCurrentSession().delete(department);
		
	}

	@Override
	@Transactional
	public List<Department> getDepartments(int employeeId) {
		
		//Oddziały należące tylko do danego pracownika
		//Select * from Department where employee_id = 14;

		Session curSession = sessionFactory.getCurrentSession();
		
		Query<Department> theQuery = 
				curSession.createQuery("from Department where employee.id=:employeeId");
		theQuery.setParameter("employeeId", employeeId);
		
		List<Department> departments = theQuery.getResultList();
		return departments;
	}

	

	@Override
	@Transactional
	public List<Department> getAllDepartments() {

		//e. x. PostgreSQL synthax = Select * from Department;

		
		
		Session curSession = sessionFactory.getCurrentSession();
		
		
		
		Query<Department> theQuery = 
				curSession.createQuery("from Department",
											Department.class);
		
		
		List<Department> departments = theQuery.getResultList();
				
				
		return departments;
	}
	

}
