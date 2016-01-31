package com.epam.threads.bean;

import org.apache.log4j.Logger;

public class Producer implements Runnable {
	
	private static Logger logger = Logger.getLogger(Producer.class);
	private SharedResouce resource;
	
	public Producer(SharedResouce resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		logger.info("Producer starts");
		for (int i = 0; i < 10; i++) {
			resource.increment();
		}
	}
}
