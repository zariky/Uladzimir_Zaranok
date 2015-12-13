package com.epam.abstractFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractFactoryPatternDemo {

	public static void main(String[] args) {
		
		AbstractFactory personFactory = FactoryProducer.getFactory("person");
		AbstractFactory dataManagerFactory = FactoryProducer.getFactory("dataManager");
		Properties props = getProperties();
		
		IDataManager dataManager = dataManagerFactory.getDataManagerFactory(props.getProperty("dataManagerFactory"));
		
		Person person1 = personFactory.getPersonFactory(props.getProperty("personType"));
		person1.setName(props.getProperty("personName"));
		person1.setAddress(props.getProperty("personAddress"));
		person1.setFaculty(props.getProperty("personFaculty"));
		person1.setSalary(Integer.parseInt(props.getProperty("personSalary")));
		
		dataManager.writePerson(person1);
		Person readedPerson = dataManager.readPerson();
		if (readedPerson != null) {
			System.out.println(readedPerson.toString() + readedPerson.getClass().getSimpleName());
		} else {
			System.out.println("Person doesn't found!");
		}
		
		
		/*Person person2 = personFactory.getPersonFactory("teacher");
		person2.setName("Tim");
		dataManager.writePerson(person1);
		dataManager.writePerson(person2);
		dataManager.readPerson("dfg");*/
	}

	private static Properties getProperties() {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("config.properties");
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}
}
