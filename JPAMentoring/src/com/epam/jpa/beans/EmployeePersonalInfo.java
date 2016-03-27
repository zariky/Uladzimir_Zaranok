package com.epam.jpa.beans;

import javax.persistence.*;

@Entity
public class EmployeePersonalInfo {

	private int id;
	private String characteristic;
	private Employee employee;
	
	public EmployeePersonalInfo(String characteristic) {
		super();
		this.characteristic = characteristic;
	}

	public EmployeePersonalInfo() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

	@OneToOne
	@JoinColumn(name = "employee_id")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeePersonalInfo [id=" + id + ", characteristic=" + characteristic + ", employee=" + employee + "]";
	}
	
}
