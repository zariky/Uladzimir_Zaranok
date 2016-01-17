package com.epam.memory.examples;

public class StackOverflowError {
	class L1 {
		L2 l;

		L1() {
			l = new L2();
		}
	}

	class L2 {
		L1 l;

		L2() {
			l = new L1();
		}
	}

	public void start() {
		L1 l = new L1();
	}

	public static void main(String[] args) {
		new StackOverflowError().start();
	}
	

}
