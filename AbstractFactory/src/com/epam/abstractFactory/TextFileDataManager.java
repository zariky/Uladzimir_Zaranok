package com.epam.abstractFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TextFileDataManager implements IDataManager {

	@Override
	public void writePerson(Person person) {

		try (FileOutputStream fos = new FileOutputStream("persons.txt",	false);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(person);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Person readPerson() {
		Person person = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persons.txt"));) {
			person = (Person) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}

	@Override
	public Person readPerson(String name) {
		Person person = null;
		try (FileInputStream fis = new FileInputStream("persons.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			person = (Person) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person != null && person.getName().equalsIgnoreCase(name) ? person : null;
	}
}
