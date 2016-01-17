package com.epam.memory.examples;

public class StackOverflowError {
	class Leak1 {
		Leak2 l;
		Leak1() {
			l = new Leak2();
		}
	}

	class Leak2 {
		Leak1 l;
		Leak2() {
			l = new Leak1();
		}
	}

	public void start() {
		Leak1 l = new Leak1();
	}

	public static void main(String[] args) {
		new StackOverflowError().start();
	}
	
}
