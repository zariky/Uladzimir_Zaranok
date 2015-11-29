package com.epam;

public class Car {
	
	private String make;
	private String model;
	private String manufacturer;
	private Engine engine;
	private GearBox gearBox;

	public Car(String make, String model, String manufacturer, Engine engine, GearBox gearBox) {
		this.make = make;
		this.model = model;
		this.manufacturer = manufacturer;
		this.engine = engine;
		this.gearBox = gearBox;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public GearBox getGearBox() {
		return gearBox;
	}

	public void setGearBox(GearBox gearBox) {
		this.gearBox = gearBox;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", manufacturer="
				+ manufacturer + ", engine=" + engine + ", gearBox=" + gearBox
				+ "]";
	}
	
}
