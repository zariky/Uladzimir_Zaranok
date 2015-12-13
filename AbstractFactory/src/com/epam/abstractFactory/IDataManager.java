package com.epam.abstractFactory;

public interface IDataManager {
	void writePerson (Person person);
	Person readPerson();
	Person readPerson (String name);
}
