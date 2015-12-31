package com.epam.classloader.factories;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.epam.classloader.customclassloader.CustomJarClassLoader;
import com.epam.classloader.ifaces.IMessage;
import com.epam.classloader.internal.beans.EnglishMessenger;

public class MessengerFactory {
	private static final String JAR_PATH = "Beans.jar";
	private static final Logger LOGGER = Logger.getLogger(MessengerFactory.class);
	
	public static IMessage getMessengerClass(int choice) {
		
		switch (choice) {
		case 1:
			return new EnglishMessenger();
		case 2:
			return (IMessage) loadClassFromJar("com.epam.classloader.external.beans.GermanMessenger", JAR_PATH);
		case 3:
			return (IMessage) loadClassFromJar("com.epam.classloader.external.beans.ItalianMessenger", JAR_PATH);
		case 4:
			return (IMessage) loadClassFromJar("com.epam.classloader.external.beans.RussianMessenger", JAR_PATH);
		default:
			LOGGER.info("Wrong choice");
		}
		return null;
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

	public static void getClassInfo(IMessage clazz) {
		if (clazz != null) {
			clazz.sendMessage();
			LOGGER.info("Loaded by: " + clazz.getClass().getClassLoader().getClass().getName());
		} else {
			LOGGER.info("Method getClassInfo() can't retrieve information from null parameter");
		}
	}
}
