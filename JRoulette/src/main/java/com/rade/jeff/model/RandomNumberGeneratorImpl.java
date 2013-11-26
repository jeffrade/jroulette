package com.rade.jeff.model;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomNumberGeneratorImpl implements NumberGenerator{
	
	private static final Logger LOG = LoggerFactory.getLogger(RandomNumberGeneratorImpl.class);
	
	private Random random = new Random();

	@Override
	public int generateNumber(int numberOfIntegers) {
		int randomNumber = random.nextInt(numberOfIntegers);
		if(randomNumber < 0 || randomNumber >= numberOfIntegers){
			LOG.error("ERROR! random number = " + randomNumber + ".  Should not have generated this number.");
		}
		return randomNumber;
	}

}
