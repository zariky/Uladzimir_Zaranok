package com.epam.abstractFactory;

public class Student extends Person {
	
	private static final long serialVersionUID = 1L;

	public Student() {
		
	}
			
	public Student(String name, String address, String faculty,  int salary) {
		 super(name, address, faculty, salary);
	}
	
	@Override
	public String sayGreeting() {
		System.out.println("Hi I'm Student");
		return "Hi I'm Student";
	}
	
}
