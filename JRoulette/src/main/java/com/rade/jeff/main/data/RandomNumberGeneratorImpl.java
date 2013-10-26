package com.rade.jeff.main.data;

public class RandomNumberGeneratorImpl implements NumberGenerator{

	@Override
	public int generateNumber(int numberOfIntegers) {
		int randomNumber = (int) ((numberOfIntegers) * Math.random());
		if(randomNumber < 0 || randomNumber >= numberOfIntegers){
			System.out.println("ERROR! random number = " + randomNumber + ".  Should not have generated this number.");
		}
		return randomNumber;
	}

}
