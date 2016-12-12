package com.qjg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Console1403_3Test {

	private static Console1403_3 c = new Console1403_3();
//	@Test
	public void testCheckFormatStr() {
//		fail("Not yet implemented");
	//	System.out.println(c.checkFormatStr("albw:x"));
//		assertEquals(c.checkFormatStr("albw:x"),true);
//		System.out.println(c.checkFormatStr("aAbw:x"));
//		assertEquals(c.checkFormatStr("aAbw:x"),false);
		assertEquals(c.checkFormatStr("aAbw::x"),false);
		
	}

	@Test
	public void testCheckCommand() {
//		fail("Not yet implemented");
		assertEquals(c.checkCommand("ls -A -l"),false);
		
	}

//	@Test
	public void testAnalysCommand() {
		fail("Not yet implemented");
	}

//	@Test
	public void testJudgeParameter() {
		fail("Not yet implemented");
	}

//	@Test
	public void testIsY() {
		fail("Not yet implemented");
	}

//	@Test
	public void testIsN() {
		fail("Not yet implemented");
	}

//	@Test
	public void testAnalys() {
		fail("Not yet implemented");
	}

}
