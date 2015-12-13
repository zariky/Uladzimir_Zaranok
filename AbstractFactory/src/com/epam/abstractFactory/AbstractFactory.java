package com.epam.abstractFactory;

public abstract class AbstractFactory {
	abstract Person getPersonFactory(String personType);
	abstract IDataManager getDataManagerFactory(String dataType);
}
