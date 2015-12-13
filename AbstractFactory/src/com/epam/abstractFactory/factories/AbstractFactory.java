package com.epam.abstractFactory.factories;

import com.epam.abstractFactory.beans.Person;
import com.epam.abstractFactory.interfaces.IDataManager;

public abstract class AbstractFactory {
	public abstract Person getPersonFactory(String personType);
	public abstract IDataManager getDataManagerFactory(String dataType);
}
