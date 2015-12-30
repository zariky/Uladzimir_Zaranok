package com.epam.classloader.internal.beans;

import com.epam.classloader.ifaces.IMessage;

public class EnglishMessenger implements IMessage {

	@Override
	public void sendMessage() {
		System.out.println("Hello World!");
	}

}
