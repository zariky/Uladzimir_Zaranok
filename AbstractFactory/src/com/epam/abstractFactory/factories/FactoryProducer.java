package com.epam.abstractFactory.factories;


public class FactoryProducer {
	
	public static AbstractFactory getFactory(String choice){
		if (choice.equalsIgnoreCase("person")) {
			return new PersonFactory();
		} else if (choice.equalsIgnoreCase("dataManager")) {
			return new DataManagerFactory();
		} else {
			return null;
		}
		
	}
}
