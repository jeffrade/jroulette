package com.rade.jeff.model;

import java.util.Random;

public class RandomNumberGeneratorImpl implements NumberGenerator{
	
	private Random random = new Random();

	@Override
	public int generateNumber(int numberOfIntegers) {
		int randomNumber = random.nextInt(numberOfIntegers);
		if(randomNumber < 0 || randomNumber >= numberOfIntegers){
			System.out.println("ERROR! random number = " + randomNumber + ".  Should not have generated this number.");
		}
		return randomNumber;
	}

}
