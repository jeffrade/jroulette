package com.rade.jeff.main.data;

public class BetFactory {
	
	private static final AmericanBet AMERICAN_BET_REF = new AmericanBet();
	
	private static final EuropeanBet EUROPEAN_BET_REF = new EuropeanBet();
	
	public static Bet getBetByLocale(int type, String betName, int amount){
		return type == RouletteWheel.AMERICAN_NUMBERS ? new AmericanBet(betName, new Money(amount)) : new EuropeanBet(betName, new Money(amount));
	}

	public static String[] getBetArrayByLocale(int type) {
		return type == RouletteWheel.AMERICAN_NUMBERS ? AMERICAN_BET_REF.getArrayOfBets() : EUROPEAN_BET_REF.getArrayOfBets();
	}
	
	public static Bet getBetByLocale(int type){
		return type == RouletteWheel.AMERICAN_NUMBERS ? new AmericanBet() : new EuropeanBet();
	}

}
