package com.epam.threads.bean;

import org.apache.log4j.Logger;

public class SharedResouce {
	
	private static Logger logger = Logger.getLogger(SharedResouce.class);
	private int resource = 10;

    public synchronized void increment() {
    	 while (resource >= 10) {
             try {
            	 logger.info(Thread.currentThread().getName() + " thread is waiting on increment");
                 wait();
             } catch (InterruptedException e) {}
         }
    	resource++;
    	logger.info(Thread.currentThread().getName() + " thread incremented value: " + resource);
    	notifyAll();
    }

    public synchronized void decrement() {
    	while (resource < 5) {
            try {
            	logger.info(Thread.currentThread().getName() + " thread is waiting on decrement");
                wait();
            } catch (InterruptedException e) {}
        }
    	resource--;
    	logger.info(Thread.currentThread().getName() + " thread decremented value: " + resource);
    	notifyAll();
    }

    public synchronized int value() {
    	logger.info(Thread.currentThread().getName() + " thread takes value: " + resource);
        return resource;
    }
}
