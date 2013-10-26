package com.rade.jeff.main.data;

import java.util.HashMap;
import java.util.Map;

public class RollResult {
	
	private int number;
	
	private String color;
	
	private static final String RED = "RED";
	
	private static final String BLACK = "BLACK";
	
	private static final String GREEN = "GREEN";
	
	private static final Map<Integer,String> numberColorMap = new HashMap<Integer,String>();
	
	static{
		numberColorMap.put(0, GREEN);
		numberColorMap.put(37, GREEN);
		numberColorMap.put(2, BLACK);
		numberColorMap.put(4, BLACK);
		numberColorMap.put(6, BLACK);
		numberColorMap.put(8, BLACK);
		numberColorMap.put(10, BLACK);
		numberColorMap.put(11, BLACK);
		numberColorMap.put(13, BLACK);
		numberColorMap.put(15, BLACK);
		numberColorMap.put(17, BLACK);
		numberColorMap.put(20, BLACK);
		numberColorMap.put(22, BLACK);
		numberColorMap.put(24, BLACK);
		numberColorMap.put(26, BLACK);
		numberColorMap.put(28, BLACK);
		numberColorMap.put(29, BLACK);
		numberColorMap.put(31, BLACK);
		numberColorMap.put(33, BLACK);
		numberColorMap.put(35, BLACK);
		numberColorMap.put(1, RED);
		numberColorMap.put(3, RED);
		numberColorMap.put(5, RED);
		numberColorMap.put(7, RED);
		numberColorMap.put(9, RED);
		numberColorMap.put(12, RED);
		numberColorMap.put(14, RED);
		numberColorMap.put(16, RED);
		numberColorMap.put(18, RED);
		numberColorMap.put(19, RED);
		numberColorMap.put(21, RED);
		numberColorMap.put(23, RED);
		numberColorMap.put(25, RED);
		numberColorMap.put(27, RED);
		numberColorMap.put(30, RED);
		numberColorMap.put(32, RED);
		numberColorMap.put(34, RED);
		numberColorMap.put(36, RED);
	}
	
	public void setNumber(int num){
		number = num;
	}
	
	public void setColor(int num){
		color = numberColorMap.get(Integer.valueOf(num));
	}
	
	public int getNumber(){
		return number;
	}
	
	public String getColor(){
		return color;
	}
}
