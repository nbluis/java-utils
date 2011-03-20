package com.javautils;

public class StringUtils {

	private static final char CHARACTER_SPACE = ' ';

	public StringUtils() {}

	public static final String lPad(String value, int length) {
		return lPad(value, length, CHARACTER_SPACE);
	}

	public static final String lPad(String value, int length, char pad) {
		if (length <= 0) throw new IllegalArgumentException("invalid argument");
		char[] newValue = new char[length];
		char[] tmp = (value != null) ? value.toCharArray() : new char[0];
		int padSize = length - tmp.length;
		for (int i = 0; i < length; i++)
			newValue[i] = (i < padSize) ? pad : tmp[i - padSize];
		return new String(newValue);
	}

	public static final String rPad(String value, int length) {
		return rPad(value, length, CHARACTER_SPACE);
	}

	public static final String rPad(String value, int length, char pad) {
		if (length <= 0) throw new IllegalArgumentException("invalid argument");
		char[] newValue = new char[length];
		char[] tmp = (value != null) ? value.toCharArray() : new char[0];
		for (int i = 0; i < length; i++)
			newValue[i] = (i < tmp.length) ? tmp[i] : pad;
		return new String(newValue);
	}

}
