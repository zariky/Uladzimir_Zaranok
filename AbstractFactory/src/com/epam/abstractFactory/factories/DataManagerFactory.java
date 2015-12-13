package com.epam.abstractFactory.factories;

import com.epam.abstractFactory.beans.Person;
import com.epam.abstractFactory.factoriesImplementation.DataBaseFileDataManager;
import com.epam.abstractFactory.factoriesImplementation.TextFileDataManager;
import com.epam.abstractFactory.interfaces.IDataManager;

public class DataManagerFactory extends AbstractFactory {

	@Override
	public Person getPersonFactory(String personType) {
		return null;
	}

	@Override
	public IDataManager getDataManagerFactory(String dataType) {
		if (dataType.equalsIgnoreCase("txt")) {
			return new TextFileDataManager();
		} else if (dataType.equalsIgnoreCase("db")) {
			return new DataBaseFileDataManager();
		} else {
			return null;
		}
	}

}
