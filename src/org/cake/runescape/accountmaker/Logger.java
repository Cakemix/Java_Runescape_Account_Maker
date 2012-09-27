package org.cake.runescape.accountmaker;

public class Logger {
	public static boolean debug = true;

	public static void debug(String value, Object... args) {
		if (debug)
			System.out.printf(value + '\n', args);
	}

	public static void info(String value, Object... args) {
		System.out.printf(value + '\n', args);
	}
}
