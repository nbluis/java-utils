package com.javautils;

import static com.javautils.DateUtils.truncate;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void testTruncateInvalidCall() {
		try {
			truncate(null, -1);
			fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

		try {
			truncate(new Date(), -1);
			fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

		try {
			truncate(null, Calendar.YEAR);
			fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}
	}

	@Test
	public void testTruncateMilisecon() {
		Calendar cal = Calendar.getInstance();
		Date parameter = cal.getTime();
		cal.set(Calendar.MILLISECOND, 0);
		assertEquals(cal.getTime().getTime(), truncate(parameter, Calendar.MILLISECOND).getTime());
	}

	@Test
	public void testTruncateSecond() {
		Calendar cal = Calendar.getInstance();
		Date parameter = cal.getTime();
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		assertEquals(cal.getTime().getTime(), truncate(parameter, Calendar.SECOND).getTime());
	}

	@Test
	public void testTruncateMinute() {
		Calendar cal = Calendar.getInstance();
		Date parameter = cal.getTime();
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		assertEquals(cal.getTime().getTime(), truncate(parameter, Calendar.MINUTE).getTime());
	}

	@Test
	public void testTruncateHour() {
		Calendar cal = Calendar.getInstance();
		Date parameter = cal.getTime();
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		assertEquals(cal.getTime().getTime(), truncate(parameter, Calendar.HOUR_OF_DAY).getTime());
	}

	@Test
	public void testTruncateDay() {
		Calendar cal = Calendar.getInstance();
		Date parameter = cal.getTime();
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		assertEquals(cal.getTime().getTime(), truncate(parameter, Calendar.DAY_OF_MONTH).getTime());
	}

	@Test
	public void testTruncateMonth() {
		Calendar cal = Calendar.getInstance();
		Date parameter = cal.getTime();
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 0);
		assertEquals(cal.getTime().getTime(), truncate(parameter, Calendar.MONTH).getTime());
	}

	@Test
	public void testTruncateYear() {
		Calendar cal = Calendar.getInstance();
		Date parameter = cal.getTime();
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 1);
		assertEquals(cal.getTime().getTime(), truncate(parameter, Calendar.YEAR).getTime());

	}
}
