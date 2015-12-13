package com.epam.abstractFactory.factories;

import com.epam.abstractFactory.beans.Person;
import com.epam.abstractFactory.beans.Student;
import com.epam.abstractFactory.beans.Teacher;
import com.epam.abstractFactory.interfaces.IDataManager;

public class PersonFactory extends AbstractFactory {

	@Override
	public Person getPersonFactory(String personType) {
		if (personType.equalsIgnoreCase("student")) {
			return new Student();
		} else if (personType.equalsIgnoreCase("teacher")) {
			return new Teacher();
		} else {
			return null;
		}
	}

	@Override
	public IDataManager getDataManagerFactory(String dataType) {
		return null;
	}

}
