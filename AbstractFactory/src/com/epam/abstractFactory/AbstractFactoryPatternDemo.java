package com.epam.abstractFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.epam.abstractFactory.beans.Person;
import com.epam.abstractFactory.factories.AbstractFactory;
import com.epam.abstractFactory.factories.FactoryProducer;
import com.epam.abstractFactory.interfaces.IDataManager;

public class AbstractFactoryPatternDemo {

	public static void main(String[] args) {
		
		AbstractFactory personFactory = FactoryProducer.getFactory("person");
		AbstractFactory dataManagerFactory = FactoryProducer.getFactory("dataManager");
		Properties props = getProperties();
		
		IDataManager dataManager = dataManagerFactory.getDataManagerFactory(props.getProperty("dataManagerFactory"));
		
		Person person = personFactory.getPersonFactory(props.getProperty("personType"));
		person.setName(props.getProperty("personName"));
		person.setAddress(props.getProperty("personAddress"));
		person.setFaculty(props.getProperty("personFaculty"));
		person.setSalary(Integer.parseInt(props.getProperty("personSalary")));
		
		dataManager.writePerson(person);
		System.out.println("Person = " + person.getClass().getSimpleName() + " successfully writed to " + props.getProperty("dataManagerFactory"));
		
		Person readedPerson = dataManager.readPerson(props.getProperty("nameForSearch"));
		if (readedPerson != null) {
			System.out.println("Person = " + readedPerson.getClass().getSimpleName() + " successfully readed from " + props.getProperty("dataManagerFactory"));
		} else {
			System.out.println("Person doesn't found" + " in " + props.getProperty("dataManagerFactory"));
		}
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
