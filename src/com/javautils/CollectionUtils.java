package com.javautils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
	private CollectionUtils() {
		// no instanciable
	}

	public static <V> List<List<V>> group(List<V> list, Comparator<V> comparator) {
		if (list == null || comparator == null) throw new IllegalArgumentException("invalid parameter");
		Collections.sort(list, comparator);
		List<List<V>> returnList = new ArrayList<List<V>>();

		V lastEntry = null;
		List<V> lastSublist = null;

		for (V entry : list) {
			if (lastEntry == null || comparator.compare(lastEntry, entry) != 0) {
				lastSublist = new ArrayList<V>();
				returnList.add(lastSublist);
			}
			lastSublist.add(entry);
			lastEntry = entry;
		}
		return returnList;
	}

	public static <V extends Comparable<V>> List<List<V>> group(List<V> list) {
		if (list == null) throw new IllegalArgumentException("invalid parameter");
		Collections.sort(list);
		List<List<V>> returnList = new ArrayList<List<V>>();

		V lastEntry = null;
		List<V> lastSublist = null;

		for (V entry : list) {
			if (lastEntry == null || lastEntry.compareTo(entry) != 0) {
				lastSublist = new ArrayList<V>();
				returnList.add(lastSublist);
			}
			lastSublist.add(entry);
			lastEntry = entry;
		}
		return returnList;
	}

}
