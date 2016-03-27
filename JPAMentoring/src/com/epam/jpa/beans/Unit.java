package com.epam.jpa.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Unit {
	
	public Unit() {
		super();
	}
	
	public Unit(String name) {
		super();
		this.name = name;
	}

	private int id;
	
	private String name;
	
	private List<Employee> employees = new ArrayList<Employee>() ;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "unit_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany
	@JoinColumn(referencedColumnName = "unit_id")
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Unit [id=" + id + ", name=" + name + "]";
	}
	
}
