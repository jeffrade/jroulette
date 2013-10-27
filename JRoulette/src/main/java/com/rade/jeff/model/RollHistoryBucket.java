package com.rade.jeff.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RollHistoryBucket implements Serializable{
	
	/**
	 * Default
	 */
	private static final long serialVersionUID = 9239523842956730L;

	private List<String> numbers;
	
	private List<String> colors;
	
	private int holderCount;
	
	private static final int DEFAULT_HOLDER_COUNT = 15;
	
	private static final String HTML_NBSP = "&nbsp;";
	
	public RollHistoryBucket(){
		super();
		this.numbers = new ArrayList<String>();
		this.colors = new ArrayList<String>();
		this.holderCount = DEFAULT_HOLDER_COUNT;
		initList(this.numbers, this.colors, this.holderCount);
	}
	
	public RollHistoryBucket(List<String> numbers, List<String> colors, int holderCount){
		super();
		this.numbers = numbers;
		this.colors = colors;
		this.holderCount = holderCount;
		initList(this.numbers, this.colors, this.holderCount);
	}
	
	public static void initList(List<String> numbers, List<String> colors, int holderCount){
		for(int i = 1; i <= holderCount; i++){
			numbers.add(HTML_NBSP);
			colors.add(HTML_NBSP);
		}
	}
	
	public String getLastNumber(){
		return numbers.get(numbers.size() - 1);
	}
	
	public String getLastColor(){
		return colors.get(colors.size() - 1);
	}

	public List<String> getNumbers() {
		if(this.numbers.size() <= DEFAULT_HOLDER_COUNT){
			return numbers;
		} else{
			return numbers.subList(numbers.size() - holderCount, numbers.size());	
		}
	}

	public void setNumbers(List<String> numbers) {
		this.numbers = numbers;
	}

	public List<String> getColors() {
		if(this.colors.size() <= DEFAULT_HOLDER_COUNT){
			return colors;
		} else{
			return colors.subList(colors.size() - holderCount, colors.size());	
		}
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}
	
	public void addNumber(String number){
		this.numbers.add(number);
	}
	
	public void addNumber(int number){
		this.numbers.add(String.valueOf(number));
	}
	
	public void addColor(String color){
		this.colors.add(color);
	}

}
