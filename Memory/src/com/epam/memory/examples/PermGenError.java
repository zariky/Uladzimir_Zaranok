package com.epam.memory.examples;

import javassist.ClassPool;

public class PermGenError {
	static ClassPool cp = ClassPool.getDefault();

	public static void main(String[] args) throws Exception{
		for (int i = 0; ; i++) { 
			Class c = cp.makeClass("com.epam.demo.ClassLoad" + i).toClass();
		}
	}
	
}
