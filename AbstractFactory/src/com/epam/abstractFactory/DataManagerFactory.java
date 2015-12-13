package com.epam.abstractFactory;

public class DataManagerFactory extends AbstractFactory {

	@Override
	Person getPersonFactory(String personType) {
		return null;
	}

	@Override
	IDataManager getDataManagerFactory(String dataType) {
		if (dataType.equalsIgnoreCase("txt")) {
			return new TextFileDataManager();
		} else if (dataType.equalsIgnoreCase("DB")) {
			return new DataBasetFileDataManager();
		} else {
			return null;
		}
	}

}
