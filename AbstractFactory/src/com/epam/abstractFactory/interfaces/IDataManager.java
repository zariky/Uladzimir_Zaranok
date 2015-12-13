package com.epam.abstractFactory.interfaces;

import com.epam.abstractFactory.beans.Person;

public interface IDataManager {
	void writePerson (Person person);
	Person readPerson();
	Person readPerson (String name);
}
