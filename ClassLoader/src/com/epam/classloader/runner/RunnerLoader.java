package com.epam.classloader.runner;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.epam.classloader.factories.MessengerFactory;
import com.epam.classloader.ifaces.IMessage;

public class RunnerLoader {
	
	private static final Logger LOGGER = Logger.getLogger(RunnerLoader.class);

	public static void main(String[] args) {
		
		int choice = showMenu();
		IMessage clazz = MessengerFactory.getMessengerClass(choice);
		MessengerFactory.getClassInfo(clazz);
	}
	
	private static int showMenu() {
		int choice = 0;
		LOGGER.info("Choose from menu");
		LOGGER.info("-------------------------");
		LOGGER.info("1 - English internal greeting");
		LOGGER.info("2 - German external greeting");
		LOGGER.info("3 - Italian external greeting");
		LOGGER.info("4 - Russian external greeting");
		LOGGER.info("-------------------------\n");
		LOGGER.info("Please enter a number:");	
		try (Scanner scanner = new Scanner(System.in)) {
			choice = scanner.nextInt();
		} catch (InputMismatchException e) {
			LOGGER.info("Entered symbol is not a number");
		}
		return choice;
	}
}
