package com.epam.jpa.runner;

import javax.persistence.*;

import com.epam.jpa.beans.Address;
import com.epam.jpa.beans.Employee;
import com.epam.jpa.beans.EmployeePersonalInfo;
import com.epam.jpa.beans.EmployeeStatus;
import com.epam.jpa.beans.Project;
import com.epam.jpa.beans.Unit;
import com.epam.jpa.services.EmployeeService;
import com.epam.jpa.services.ProjectService;
import com.epam.jpa.services.UnitService;

public class Runner {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAMentoring");
	    EntityManager em = emf.createEntityManager();
	    
	    EmployeeService employeeService = new EmployeeService(em);
	    UnitService unitService = new UnitService(em);
	    ProjectService projectService = new ProjectService(em);

        em.getTransaction().begin();
         
        Project project1 = new Project("Project1");
        projectService.createProject(project1);
        Project project2 = new Project("Project2");
        projectService.createProject(project2);
        
        Address address = new Address("Country", "City", "Street");
        
        Unit unit = new Unit("Unit1");
        unitService.createUnit(unit);
        
        EmployeePersonalInfo info = new EmployeePersonalInfo("Characteristic");
        em.persist(info);
         
        Employee employee1 = new Employee("John", "Smith", EmployeeStatus.FULLTIME, address, info);
        
        employeeService.createEmployee(employee1);
        
        unitService.addEmployeeToUnit(employee1.getId(), unit.getId());
        
        employeeService.assignEmployeeToProject(project1.getId(), employee1.getId());
        employeeService.assignEmployeeToProject(project2.getId(), employee1.getId());
        
        Employee foundEmp = employeeService.findEmployee(employee1.getId());
        
        em.getTransaction().commit();
        em.close();
        
        System.out.println(foundEmp);
	}

}
