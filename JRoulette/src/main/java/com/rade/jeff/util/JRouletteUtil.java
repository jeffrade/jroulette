package com.rade.jeff.util;

public class JRouletteUtil {
	
	public static String[] parsePlayerNames(String[] stringArray, String seperator){
		StringBuilder completeString = new StringBuilder();
		for(String cell : stringArray){
			completeString.append(cell);
		}
		return completeString.toString().split(seperator);
	}

	public static String cleanBetName(String bet) {
		return bet.replace(" ", "_").toUpperCase();
	}

}
