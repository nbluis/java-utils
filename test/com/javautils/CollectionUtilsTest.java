package com.javautils;

import static com.javautils.CollectionUtils.group;
import static java.util.Collections.emptyList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class CollectionUtilsTest {

	@Test
	public void testInvalidArguments() {
		try {
			group((List<String>) null);
			fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

		try {
			group(null, null);
			fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

		try {
			group(emptyList(), null);
			fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

		try {
			group((List<Object>) null, new Comparator<Object>() {
				@Override
				public int compare(Object o1, Object o2) {
					return 0;
				}
			});
			fail("deve retornar exception com um valor invalido");
		} catch (IllegalArgumentException e) {}

	}

	@Test
	public void testComparableList() {
		List<List<Integer>> grouped = group(Arrays.asList(new Integer[] { 5, 4, 3, 8, 5, 2, 3, 8, 7, 1, 3, 3, 5, 2, 1 }));

		assertEquals(7, grouped.size());

		assertEquals(2, grouped.get(0).size());
		assertEquals(Integer.valueOf(1), grouped.get(0).get(0));
		assertEquals(Integer.valueOf(1), grouped.get(0).get(1));

		assertEquals(2, grouped.get(1).size());
		assertEquals(Integer.valueOf(2), grouped.get(1).get(0));
		assertEquals(Integer.valueOf(2), grouped.get(1).get(1));

		assertEquals(4, grouped.get(2).size());
		assertEquals(Integer.valueOf(3), grouped.get(2).get(0));
		assertEquals(Integer.valueOf(3), grouped.get(2).get(1));
		assertEquals(Integer.valueOf(3), grouped.get(2).get(2));
		assertEquals(Integer.valueOf(3), grouped.get(2).get(3));

		assertEquals(1, grouped.get(3).size());
		assertEquals(Integer.valueOf(4), grouped.get(3).get(0));

		assertEquals(3, grouped.get(4).size());
		assertEquals(Integer.valueOf(5), grouped.get(4).get(0));
		assertEquals(Integer.valueOf(5), grouped.get(4).get(1));
		assertEquals(Integer.valueOf(5), grouped.get(4).get(2));

		assertEquals(1, grouped.get(5).size());
		assertEquals(Integer.valueOf(7), grouped.get(5).get(0));

		assertEquals(2, grouped.get(6).size());
		assertEquals(Integer.valueOf(8), grouped.get(6).get(0));
		assertEquals(Integer.valueOf(8), grouped.get(6).get(1));
	}

	@Test
	public void testComparator() {
		List<List<String>> grouped = group(Arrays.asList(new String[] { "!5", "@4", "!3", "@8", "!5", "@2", "!3", "@8", "!7", "@1", "!3", "@3", "!5", "@2", "!1" }),
				new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						// compare by 2nd character
						return Character.valueOf(o1.charAt(1)).compareTo(Character.valueOf(o2.charAt(1)));
					}
				});

		assertEquals(7, grouped.size());

		assertEquals(2, grouped.get(0).size());
		assertEquals('1', grouped.get(0).get(0).charAt(1));
		assertEquals('1', grouped.get(0).get(1).charAt(1));

		assertEquals(2, grouped.get(1).size());
		assertEquals('2', grouped.get(1).get(0).charAt(1));
		assertEquals('2', grouped.get(1).get(1).charAt(1));

		assertEquals(4, grouped.get(2).size());
		assertEquals('3', grouped.get(2).get(0).charAt(1));
		assertEquals('3', grouped.get(2).get(1).charAt(1));
		assertEquals('3', grouped.get(2).get(2).charAt(1));
		assertEquals('3', grouped.get(2).get(3).charAt(1));

		assertEquals(1, grouped.get(3).size());
		assertEquals('4', grouped.get(3).get(0).charAt(1));

		assertEquals(3, grouped.get(4).size());
		assertEquals('5', grouped.get(4).get(0).charAt(1));
		assertEquals('5', grouped.get(4).get(1).charAt(1));
		assertEquals('5', grouped.get(4).get(2).charAt(1));

		assertEquals(1, grouped.get(5).size());
		assertEquals('7', grouped.get(5).get(0).charAt(1));

		assertEquals(2, grouped.get(6).size());
		assertEquals('8', grouped.get(6).get(0).charAt(1));
		assertEquals('8', grouped.get(6).get(1).charAt(1));

	}

}
