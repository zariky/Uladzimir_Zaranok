package com.epam;

public class CarDemo {
	
	public static void main(String[] args) {
		Engine e1 = new Engine("3.8L V6");
		GearBox g1 = new GearBox("DSG 6-Spd");
		Car c1 = new Car("Mustang", "Convertible", "Ford", e1, g1);
		Engine e2 = new Engine("4.6L V8");
		GearBox g2 = new GearBox("Manual 6-Spd");
		Car c2 = new Car("Mustang", "GT Coupe", "Ford", e2, g2);
		printCar(c1);
		printCar(c2);
	}
	
	private static void printCar(Car car) {
		System.out.println(car);
	}
	
}
