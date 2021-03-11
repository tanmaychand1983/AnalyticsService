package com.vollzo.analytics.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	/**
	 * Format the Date .
	 * @methodName: dateFormat
	 * @param fromdate - Input String
	 * @param  fromDateFormat - Input String
	 * @param  toDateFormat - Input String
	 * @return - String
	 * @author Deepak Bansal
	 * @since: Feb 20, 2021
	 */
	public static String dateFormat(String date, String fromDateFormat) {
		String toDate = "";
		String toDateFormat="dd/MM/yyyy";
		try {
			if(date !="") {
				DateFormat fromDateFormatObj = new SimpleDateFormat(fromDateFormat);
				fromDateFormatObj.setLenient(false);
				Date fromDate = fromDateFormatObj.parse(date);
				toDate = new SimpleDateFormat(toDateFormat).format(fromDate);
			}
			return toDate;
		} catch (Exception e) {
			// TODO: handle exception
			String error = "Input date and date format Mismathched";
			return e.getMessage()+" : "+error;
			
		}
	}
}
