package com.epam.classloader.runner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.epam.classloader.customclassloader.CustomJarClassLoader;
import com.epam.classloader.ifaces.IMessage;
import com.epam.classloader.internal.beans.EnglishMessenger;

public class RunnerLoader {
	
	private static final String JAR_PATH = "Beans.jar";
	private static final Logger LOGGER = Logger.getLogger(RunnerLoader.class);

	public static void main(String[] args) {
		
		LOGGER.info("Choose from menu");
		LOGGER.info("-------------------------");
		LOGGER.info("1 - English internal greeting");
		LOGGER.info("2 - German external greeting");
		LOGGER.info("3 - Italian external greeting");
		LOGGER.info("4 - Russian external greeting");
		LOGGER.info("-------------------------\n");
		LOGGER.info("Please enter a number:");
		
		int choice = 0;
		
		try (Scanner scanner = new Scanner(System.in)) {
			choice = scanner.nextInt();
		} catch (InputMismatchException e) {
		}
		
		IMessage clazz = null;

		switch (choice) {
		case 1:
			clazz = new EnglishMessenger();
			getClassInfo(clazz);
			break;
		case 2:
			clazz =	(IMessage) loadClassFromJar("com.epam.classloader.external.beans.GermanMessenger", JAR_PATH);
			getClassInfo(clazz);
			break;
		case 3:
			clazz =	(IMessage) loadClassFromJar("com.epam.classloader.external.beans.ItalianMessenger", JAR_PATH);
			getClassInfo(clazz);
			break;
		case 4:
			clazz =	(IMessage) loadClassFromJar("com.epam.classloader.external.beans.RussianMessenger", JAR_PATH);
			getClassInfo(clazz);
			break;
		default:
			LOGGER.info("Wrong choice");
		}
	}
	
	private static Object loadClassFromJar(String className, String jarPath) {
		List<String> jarFiles = new ArrayList<String>();
		jarFiles.add(jarPath);
		CustomJarClassLoader jarClassLoader = new CustomJarClassLoader(jarFiles);
		Class<?> myClass = null;
		Object clazz = null;
		try {
			myClass = jarClassLoader.loadClass(className);
			clazz = myClass.newInstance();
		} catch (Exception e) {
			LOGGER.info("Unable to load class: " + className);
		}
		return clazz;
	}

	private static void getClassInfo(IMessage clazz) {
		if (clazz != null) {
			clazz.sendMessage();
			LOGGER.info("Loaded by: " + clazz.getClass().getClassLoader().getClass().getName());
		} else {
			LOGGER.info("Method getClassInfo() can't retrieve information from null parameter");
		}
	}
}
