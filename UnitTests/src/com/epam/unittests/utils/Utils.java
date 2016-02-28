package com.epam.unittests.utils;

import java.math.BigInteger;

public final class Utils {

	private Utils() {
	}

	public static String concatenate(String one, String two) {
		return one + two;
	}
	
	public static BigInteger CalculateFactorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Input argument must be positive");
		}
		BigInteger inc = new BigInteger("1");
		BigInteger fact = new BigInteger("1");

		for (int c = 1; c <= n; c++) {
			fact = fact.multiply(inc);
			inc = inc.add(BigInteger.ONE);
		}
		return fact;
	}

}
