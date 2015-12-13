package com.epam.abstractFactory;

public class PersonFactory extends AbstractFactory {

	@Override
	Person getPersonFactory(String personType) {
		if (personType.equalsIgnoreCase("student")) {
			return new Student();
		} else if (personType.equalsIgnoreCase("teacher")) {
			return new Teacher();
		} else {
			return null;
		}
	}

	@Override
	IDataManager getDataManagerFactory(String dataType) {
		return null;
	}

}
