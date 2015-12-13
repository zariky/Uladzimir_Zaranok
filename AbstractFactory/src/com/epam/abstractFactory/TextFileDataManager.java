package com.epam.abstractFactory;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TextFileDataManager implements IDataManager {

	@Override
	public void writePerson(Person person) {

		try (FileOutputStream fileOut = new FileOutputStream("persons.txt",	false);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);) {

			out.writeObject(person);

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
		List<Person> recordList = new ArrayList<Person>();
		Person person = null;
		try (FileInputStream fis = new FileInputStream("persons.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)) {

			while (true) {
				try {
					Object obj = ois.readObject();
					System.out.println(obj.toString());
				} catch (EOFException e) {
					e.printStackTrace();
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
