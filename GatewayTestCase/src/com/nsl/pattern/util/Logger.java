package com.nsl.pattern.util;

/**
 * logª«¥ó
 * 
 * @author WSNPI05
 *
 */
public class Logger {
	public static void debug(String message) {
		System.out.println("debug --- " + message);
	}

	public static void info(String message) {
		System.out.println("info --- " + message);
	}

	public static void warning(String message) {
		System.out.println("warning --- " + message);
	}

	public static void error(String message) {
		System.out.println("error --- " + message);
	}
}
