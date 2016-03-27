package com.epam.jpa.services;

import javax.persistence.EntityManager;

import com.epam.jpa.beans.Employee;
import com.epam.jpa.beans.Project;

public class EmployeeService {
	private EntityManager em;
	
	public EmployeeService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public EmployeeService() {
		super();
	}

	public void createEmployee (Employee employee) {
		em.persist(employee);
	}
	
	public Employee findEmployee (int employeeId) {
		return em.find(Employee.class, employeeId);
	}
	
	public void deleteEmployee (int id) {
		Employee employee = findEmployee(id);
	    if (employee != null) {
	    	em.remove(employee);
	    }
	}
	
	public Employee updateEmployee (Employee employee) {
	    return em.merge(employee);
	}

	public void assignEmployeeToProject(int projId, int empId) {
		Project project = em.find(Project.class, projId);
		Employee employee = em.find(Employee.class, empId);
		project.getEmployees().add(employee);
		employee.getProjects().add(project);
	}

}
