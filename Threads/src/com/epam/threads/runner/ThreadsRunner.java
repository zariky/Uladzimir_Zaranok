package com.epam.threads.runner;

import com.epam.threads.bean.Consumer;
import com.epam.threads.bean.Producer;
import com.epam.threads.bean.SharedResouce;

public class ThreadsRunner {
	
	public static void main(String[] args) {
		
		SharedResouce resource = new SharedResouce();
		Thread tConsumer = new Thread(new Consumer(resource));
		Thread tProducer = new Thread(new Producer(resource));
		
		tConsumer.setName("Consumer");
		tProducer.setName("Producer");
		
		tConsumer.start();
		tProducer.start();
	}
}
