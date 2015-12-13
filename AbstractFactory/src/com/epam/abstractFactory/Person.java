package com.epam.abstractFactory;

import java.io.Serializable;

public abstract class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String address;
	private String faculty;
	private int salary;

	public abstract String sayGreeting();

	public Person() {
		
	}
			
	public Person(String name, String address, String faculty, int salary) {
		this.name = name;
		this.address = address;
		this.faculty = faculty;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
        buffer.append(name);
        buffer.append("\n");
        buffer.append(address);
        buffer.append("\n");
        buffer.append(faculty);
        buffer.append("\n");
        buffer.append(salary);
        buffer.append("\n");
        
        return buffer.toString();
	}
	
}
