package com.frankstar.servlet.study;

import java.util.LinkedHashMap;
import java.util.Map;

public class DB {
	private static Map<String, Book> map = new LinkedHashMap<String, Book>();
	static {
		map.put("1", new Book("1", "java"));
		map.put("2", new Book("2", "spring"));
		map.put("3", new Book("3", "hibernate"));
		map.put("4", new Book("4", "struts"));
		map.put("5", new Book("5", "ajax"));
	}
	public static Map<String, Book> getAll() {
		return map;
	}
}
