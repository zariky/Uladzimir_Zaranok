package com.epam.jpa.services;

import javax.persistence.EntityManager;

import com.epam.jpa.beans.Employee;
import com.epam.jpa.beans.Unit;


public class UnitService {
	private EntityManager em;

	public UnitService() {
		super();
	}

	public UnitService (EntityManager em) {
		super();
		this.em = em;
	}
	
	public void createUnit (Unit unit) {
		em.persist(unit);
	}
	
	public Unit findUnit (int unitId) {
		return em.find(Unit.class, unitId);
	}
	
	public void deleteUnit (int id) {
		Unit unit = findUnit(id);
	    if (unit != null) {
	    	em.remove(unit);
	    }
	}
	
	public Unit updateUnit (Unit unit) {
	    return em.merge(unit);
	}
	
	public void addEmployeeToUnit(int empId, int unitId) {
		Employee employee = em.find(Employee.class, empId);
		Unit unit = findUnit(unitId);
		unit.getEmployees().add(employee);
		employee.setUnit(unit);
	}
}
