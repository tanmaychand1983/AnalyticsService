package com.vollzo.analytics.util;

public class Util {
	public static String nullCheck(Object val) {
		
		if(val != null) {
			return val+"";
		}else {
			return "";
		}
	}
}
