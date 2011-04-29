package com.javautils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public DateUtils() {}

	/**
	 * Trunca a data informada retornando um novo objeto {@link Date}.
	 * 
	 * @param date data a ser truncada.
	 * @param level parametro base a ser truncado
	 * Exemplo: com data base 30/03/2010 15:27:32.567)
	 *	<ul>
	 * 	<li>Calendar.YEAR: trunca a data a partir do ano (01/jan/0001 00:00:00.000).</li>
	 * 	<li>Calendar.MONTH: trunca a data a partir do mes (01/jan/2010 00:00:00.000).</li>
	 * 	<li>Calendar.DAY_OF_MONTH trunca adata a partir do dia (01/mar/2010 00:00:00.000).</li>
	 * 	<li>Calendar.HOUR: trunca a data a partir da hora (30/mar/2010 00:00:00.000).</li>
	 * 	<li>Calendar.MINUTE: trunca a data a partir do minuto (30/mar/2010 15:00:00.000).</li>
	 * 	<li>Calendar.SECOND: trunca a data a partir do segundo (30/mar/2010 15:27:00.000).</li>
	 * 	<li>Calendar.MILLISECOND: trunca a data a partir do milisegundo (30/mar/2010 15:27:32.000).</li>
	 * 	</ul>
	 * 
	 * @return nova data truncada a partir do nivel informado.
	 */
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
