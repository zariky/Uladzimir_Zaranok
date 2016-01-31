package com.epam.threads.bean;

import org.apache.log4j.Logger;

public class Consumer implements Runnable {
	
	private static Logger logger = Logger.getLogger(Consumer.class);
	private SharedResouce resource;
	
	public Consumer(SharedResouce resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		logger.info("Consumer starts");
		for (int i = 0; i < 10; i++) {
			resource.decrement();
		}
	}
}
