package com.javautils;

import static com.javautils.StringUtils.lPad;
import static com.javautils.StringUtils.rPad;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testLPadInvalidParameters() {
		try {
			lPad(null, 0);
			fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

		try {
			lPad(null, -5);
			fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

		try {
			lPad("test", 0);
			fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

	}

	@Test
	public void testLPadNullValue() {
		assertEquals("  ", lPad(null, 2));
		assertEquals("     ", lPad(null, 5));
		assertEquals("TTTTT", lPad(null, 5, 'T'));
	}

	@Test
	public void testLPadWithValue() {
		assertEquals("st", lPad("test", 2));
		assertEquals(" test", lPad("test", 5));
		assertEquals("Ttest", lPad("test", 5, 'T'));
	}

	@Test
	public void testRPadInvalidParameters() {
		try {
			rPad(null, 0);
			fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

		try {
			rPad(null, -5);
			fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

		try {
			rPad("test", 0);
			fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

	}

	@Test
	public void testRPadNullValue() {
		assertEquals("  ", rPad(null, 2));
		assertEquals("     ", rPad(null, 5));
		assertEquals("TTTTT", rPad(null, 5, 'T'));
	}

	@Test
	public void testRPadWithValue() {
		assertEquals("te", rPad("test", 2));
		assertEquals("test ", rPad("test", 5));
		assertEquals("testT", rPad("test", 5, 'T'));
	}

}
