package com.rade.jeff;

import com.rade.jeff.main.data.AmericanBet;
import com.rade.jeff.main.data.Bet;
import com.rade.jeff.main.data.EuropeanBet;

import junit.framework.TestCase;

public class BetTest extends TestCase {
	
	public static final String VALID_BET_NAME = "BLACK";
	
	public static final String INVALID_BET_NAME = "BLCAK";
	
	public void testThreadSafety(){
		AmericanBet amBet = new AmericanBet();
		EuropeanBet eurBet = new EuropeanBet();
		
		BetRunner amRunner = new BetRunner(amBet, VALID_BET_NAME);
		BetRunner eurRunner = new BetRunner(eurBet, INVALID_BET_NAME);
		
		Thread t1 = new Thread(amRunner);
		Thread t2 = new Thread(eurRunner);
		
		int count = 0;
		System.out.println("Starting...");
		while(t1.isAlive() && t2.isAlive() || count == 0){
			if(count == 0){
				t1.start();
				System.out.println("Started thread 1...");
				t2.start();
				System.out.println("Started thread 2...");
			}
			System.out.println("Starting assertion...");
			assertEquals(true, amRunner.isValid() && !eurRunner.isValid());
			System.out.println("Finished assertion for the " + ++count + " time");
		}
		
		while(t1.isAlive() || t2.isAlive()){
			if(t1.isAlive()){
				System.out.println("Waiting for thread 1 to complete...");
			}
			if(t1.isAlive()){
				System.out.println("Waiting for thread 2 to complete...");
			}
		}
		System.out.println("Done! Tested " + count + " times");
	}
	
	public class BetRunner implements Runnable{
		
		public Bet bet;
		public String betName;
		public boolean valid;
		
		public BetRunner(Bet bet, String betName){
			super();
			this.bet = bet;
			this.betName = betName;
		}

		@Override
		public void run() {
			for(int i = 0; i < 1000; i++){
				System.out.println("Checking if bet is valid...");
				valid = bet.isValidBet(betName);
				System.out.println("Finished validation of bet");
			}
		}
		
		public boolean isValid(){
			return valid;
		}
	}	
}