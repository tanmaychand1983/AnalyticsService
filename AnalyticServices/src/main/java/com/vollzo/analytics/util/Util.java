package com.vollzo.analytics.util;

public class Util {
	public static String nullCheck(Object val) {

		if (val != null) {
			return val + "";
		} else {
			return "";
		}
	}

	/**
	 * Format the String into Camel Case.
	 * 
	 * @methodName: stringFormat
	 * @param str - Input String
	 * @return - String
	 * 
	 * @author Ajaya Kar
	 * @since: Feb 2, 2021
	 */
	public static String stringFormat(String str) {
		if (str == null) {
			return " ";
		} else {
			String text = str.toLowerCase();
			char[] charArray = text.toCharArray();
			boolean foundSpace = true;
			for (int i = 0; i < charArray.length; i++) {
				if (Character.isLetter(charArray[i])) {
					if (foundSpace) {
						charArray[i] = Character.toUpperCase(charArray[i]);
						foundSpace = false;
					}
				} else {
					foundSpace = true;
				}
			}
			text = String.valueOf(charArray);
			return text;
		}
	}
}
