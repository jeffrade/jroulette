package com.rade.jeff.model;

import java.io.Serializable;

public class RouletteWheel implements Serializable{

	/**
	 * Default
	 */
	private static final long serialVersionUID = 1L;
	
	private static NumberGenerator generator;
	
	public static final int AMERICAN_NUMBERS = 38;
	
	public static final int EUROPEAN_NUMBERS = 37;
	
	private int numberOfIntegers;
	
	public RouletteWheel(NumberGenerator numberGenerator, int numberOfIntegers){
		super();
		generator = numberGenerator;
		this.numberOfIntegers = numberOfIntegers;
	}
	
	public RollResult spin(){
		RollResult result = new RollResult();
		
		int generatedNumber = generator.generateNumber(numberOfIntegers);
		result.setNumber(generatedNumber);
		result.setColor(generatedNumber);
		
		return result;
	}

	public int getNumberOfIntegers() {
		return numberOfIntegers;
	}

}