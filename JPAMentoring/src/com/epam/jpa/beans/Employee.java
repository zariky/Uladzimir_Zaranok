package com.epam.jpa.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private EmployeeStatus status;
	private Address address;
	private EmployeePersonalInfo pesonalInfo;
	private List<Project> projects = new ArrayList<Project>();
	private Unit unit;
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName,
			EmployeeStatus status, Address address,
			EmployeePersonalInfo pesonalInfo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.address = address;
		this.pesonalInfo = pesonalInfo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Enumerated(EnumType.STRING)
	public EmployeeStatus getStatus() {
		return status;
	}

	public void setStatus(EmployeeStatus status) {
		this.status = status;
	}

	@Embedded
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@OneToOne
	@JoinColumn(referencedColumnName = "employee_id")
	public EmployeePersonalInfo getPesonalInfo() {
		return pesonalInfo;
	}

	public void setPesonalInfo(EmployeePersonalInfo pesonalInfo) {
		this.pesonalInfo = pesonalInfo;
	}

	 @ManyToMany(cascade = {CascadeType.ALL})
	 @JoinTable(name="employee_project",
	 			joinColumns={@JoinColumn(name="employee_id")}, 
	 			inverseJoinColumns={@JoinColumn(name="project_id")})
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@ManyToOne
	@JoinColumn(name = "unit_id")
	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", status=" + status
				+ ", address=" + address + ", pesonalInfo=" + pesonalInfo
				+ ", projects=" + projects + ", unit=" + unit + "]";
	}
	
}
