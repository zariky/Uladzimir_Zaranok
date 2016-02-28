package com.epam.unittests.tests;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

import com.epam.unittests.utils.Utils;

public class UtilTest {
	
	@Test
	public void testConcatenate() {
		String result = Utils.concatenate("one", "two");
		assertEquals("onetwo", result);
		assertNotNull(Utils.concatenate(null, "two"));
		assertNotNull(Utils.concatenate("one", null));
		assertEquals("nullnull", Utils.concatenate(null, null));
	}

	@Test
	public void testFactorial() {
		BigInteger result = Utils.CalculateFactorial(8);
		assertEquals(new BigInteger("40320"), result);
	}
	
	@Test(timeout = 1000)
	public void testFactorialWithTimeout() {
		Random random = new Random();
		int randFact = Math.abs(random.nextInt(10000) + 1);
		BigInteger result = Utils.CalculateFactorial(randFact);
		assertNotNull(result);
		System.out.println(result.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExpectedException() {
		Utils.CalculateFactorial(-5);
	}
	
	@Ignore
	@Test
	public void testNormalizeWord() {
		fail("Ignored test");
	}
}
