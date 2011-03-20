package com.javautils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public DateUtils() {}

	public static Date truncate(Date date, int level) {
		if (date == null) throw new IllegalArgumentException("invalid date");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		switch (level) {
		case Calendar.YEAR:
			cal.set(Calendar.YEAR, cal.getActualMinimum(Calendar.YEAR));
		case Calendar.MONTH:
			cal.set(Calendar.MONTH, cal.getActualMinimum(Calendar.MONTH));
		case Calendar.DAY_OF_MONTH:
			cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		case Calendar.HOUR_OF_DAY:
			cal.set(Calendar.HOUR_OF_DAY, cal.getActualMinimum(Calendar.HOUR_OF_DAY));
		case Calendar.MINUTE:
			cal.set(Calendar.MINUTE, cal.getActualMinimum(Calendar.MINUTE));
		case Calendar.SECOND:
			cal.set(Calendar.SECOND, cal.getActualMinimum(Calendar.SECOND));
		case Calendar.MILLISECOND:
			cal.set(Calendar.MILLISECOND, cal.getActualMinimum(Calendar.MILLISECOND));
			break;
		default:
			throw new IllegalArgumentException("invalid level");
		}
		return cal.getTime();
	}
}
