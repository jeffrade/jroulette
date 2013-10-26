package com.rade.jeff;

import java.util.HashMap;
import java.util.Map;

import com.rade.jeff.main.data.NumberGenerator;
import com.rade.jeff.main.data.RandomNumberGeneratorImpl;
import com.rade.jeff.main.data.RouletteWheel;

import junit.framework.TestCase;

public class NumberGeneratorTest extends TestCase{
	
	private static final NumberGenerator generator = new RandomNumberGeneratorImpl();
	
	private static final Integer ONE = Integer.valueOf(1);

	private static final int SAMPLE_SIZE = 1000000;
	
	private static final double PERCENTAGE = 0.98;
	
	private static final double EXPECTED_VALUE_AMERICAN = SAMPLE_SIZE / RouletteWheel.AMERICAN_NUMBERS;
	
	private static final double EXPECTED_VALUE_EUROPEAN = SAMPLE_SIZE / RouletteWheel.EUROPEAN_NUMBERS;
	
	public void testRandomNumberGenerator(){
		Map<Integer, Integer> numberMap = generateNumbers(RouletteWheel.EUROPEAN_NUMBERS);
		assertEquals(RouletteWheel.EUROPEAN_NUMBERS, numberMap.size());
		numberMap = generateNumbers(RouletteWheel.AMERICAN_NUMBERS);
		assertEquals(RouletteWheel.AMERICAN_NUMBERS, numberMap.size());
		
		Map<Integer, Integer> map = generateNumbers(RouletteWheel.AMERICAN_NUMBERS);
		for(int i = 0; i < RouletteWheel.AMERICAN_NUMBERS; i++){
			assertTrue("distribution of American " + i + " is biased: was " + (1 - Math.abs(map.get(Integer.valueOf(i)).intValue() - EXPECTED_VALUE_AMERICAN)/EXPECTED_VALUE_AMERICAN), (EXPECTED_VALUE_AMERICAN - PERCENTAGE * EXPECTED_VALUE_AMERICAN) >= Math.abs(map.get(Integer.valueOf(i)).intValue() - EXPECTED_VALUE_AMERICAN));
		}
		
		map = generateNumbers(RouletteWheel.EUROPEAN_NUMBERS);
		for(int i = 0; i < RouletteWheel.EUROPEAN_NUMBERS; i++){
			assertTrue("distribution of European " + i + " is biased: was " + (1 - Math.abs(map.get(Integer.valueOf(i)).intValue() - EXPECTED_VALUE_EUROPEAN)/EXPECTED_VALUE_EUROPEAN), (EXPECTED_VALUE_EUROPEAN - PERCENTAGE * EXPECTED_VALUE_EUROPEAN) >= Math.abs(map.get(Integer.valueOf(i)).intValue() - EXPECTED_VALUE_EUROPEAN));
		}
		
	}
	
	private Map<Integer, Integer> generateNumbers(int numbers){
		Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
		int number;
		int count;
		for(int i = 0; i < SAMPLE_SIZE; i++){
			number = generator.generateNumber(numbers);
			if(numberMap.containsKey(Integer.valueOf(number))){
				count = numberMap.get(Integer.valueOf(number));
				numberMap.put(Integer.valueOf(number), Integer.valueOf(++count));
			} else {
				numberMap.put(Integer.valueOf(number), ONE);
			}
		}
		return numberMap;	
	}
}