package com.yql.test.generator.util;

public class NameFormator {
	
	/**
	 * "abc" -> "Abc"
	 * @param str
	 * @return
	 */
	public static String toUCase(String str) {
		return ("" + str.charAt(0)).toUpperCase() + str.substring(1);
	}
	
	/**
	 * "Abc" -> "abc"
	 * @param str
	 * @return
	 */
	public static String toLCase(String str) {
		return ("" + str.charAt(0)).toLowerCase() + str.substring(1);
	}
	
	/**
	 * "abc_xyz" -> "AbcXyz"
	 * @param str
	 * @return
	 */
	public static String toUUCase(String str) {
		StringBuilder sb = new StringBuilder();
		for(String s : str.split("_")) {
			sb.append(toUCase(s));
		}
		return sb.toString();
	}
	public static String toUfirst(String name) {
		String first = name.substring(0, 1).toUpperCase();
		String rest = name.substring(1, name.length());
		return new StringBuffer(first).append(rest).toString(); 
	}

}
