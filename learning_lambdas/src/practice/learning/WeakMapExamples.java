package practice.learning;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakMapExamples {

	public static void main(String[] args) {
		Map<Object, Object> weakHashMap = new WeakHashMap<>();
		Map<Object, Object> regularHashMap = new HashMap<>();

		hashMapWithStringKeys(regularHashMap);
		System.out.println("*************************");
		weakHashMapWithStringKeys(weakHashMap);
		System.out.println("*************************");
		weakHashMapWithIntKeys(weakHashMap);
	}

	private static void hashMapWithStringKeys(Map<Object, Object> regularHashMap) {
		for (int i = 0; i < 100; i++) {
			regularHashMap.put(String.valueOf(i), new Object());
			System.gc();
			System.out.println("Map size :" + regularHashMap.size());
		}

	}

	private static void weakHashMapWithStringKeys(Map<Object, Object> objectMap) {
		for (int i = 0; i < 100; i++) {
			objectMap.put(String.valueOf(i), new Object());
			System.gc();
			System.out.println("Map size :" + objectMap.size());
		}
	}

	/**
	 * 
	 * In this scenario, the int i gets converted to Integer implicitly, but
	 * Integer.class actually keeps a cache of values in the range of -128 to 127.
	 * Therefore those entries with key <= 127 will never get purged automatically.
	 */
	private static void weakHashMapWithIntKeys(Map<Object, Object> weakHashMap) {
		for (int i = 0; i < 1000; i++) {
			weakHashMap.put(i, new Object());
			System.gc();
			System.out.println("Map size :" + weakHashMap.size());
		}
		System.out.println();
	}
}
