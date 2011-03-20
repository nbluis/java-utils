package com.javautils;

import junit.framework.Assert;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testLPadInvalidParameters() {
		try {
			StringUtils.lPad(null, 0);
			Assert.fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

		try {
			StringUtils.lPad(null, -5);
			Assert.fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

		try {
			StringUtils.lPad("test", 0);
			Assert.fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

	}

	@Test
	public void testLPadNullValue() {
		String actual = StringUtils.lPad(null, 2);
		Assert.assertEquals("  ", actual);

		actual = StringUtils.lPad(null, 5);
		Assert.assertEquals("     ", actual);

		actual = StringUtils.lPad(null, 5, 'T');
		Assert.assertEquals("TTTTT", actual);
	}

	@Test
	public void testLPadWithValue() {
		String actual = StringUtils.lPad("test", 2);
		Assert.assertEquals("st", actual);

		actual = StringUtils.lPad("test", 5);
		Assert.assertEquals(" test", actual);

		actual = StringUtils.lPad("test", 5, 'T');
		Assert.assertEquals("Ttest", actual);
	}

	@Test
	public void testRPadInvalidParameters() {
		try {
			StringUtils.rPad(null, 0);
			Assert.fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

		try {
			StringUtils.rPad(null, -5);
			Assert.fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

		try {
			StringUtils.rPad("test", 0);
			Assert.fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

	}

	@Test
	public void testRPadNullValue() {
		String actual = StringUtils.rPad(null, 2);
		Assert.assertEquals("  ", actual);

		actual = StringUtils.rPad(null, 5);
		Assert.assertEquals("     ", actual);

		actual = StringUtils.rPad(null, 5, 'T');
		Assert.assertEquals("TTTTT", actual);
	}

	@Test
	public void testRPadWithValue() {
		String actual = StringUtils.rPad("test", 2);
		Assert.assertEquals("te", actual);

		actual = StringUtils.rPad("test", 5);
		Assert.assertEquals("test ", actual);

		actual = StringUtils.rPad("test", 5, 'T');
		Assert.assertEquals("testT", actual);
	}

}
