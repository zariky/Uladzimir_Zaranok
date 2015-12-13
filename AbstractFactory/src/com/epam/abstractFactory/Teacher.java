package com.epam.abstractFactory;

public class Teacher extends Person {

	private static final long serialVersionUID = 1L;

	public Teacher() {
		
	}
	
	public Teacher(String name, String address, String faculty,  int salary) {
		 super(name, address, faculty, salary);
	}

	@Override
	public String sayGreeting() {
		System.out.println("Hi I'm Teacher");
		return "Hi I'm Teacher";
	}

}
