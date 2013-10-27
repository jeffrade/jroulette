package com.rade.jeff.model;

public class Money {
	
	public static final int ONE_DOLLARS = 1;
	
	public static final int TWO_DOLLARS = 2;
	
	public static final int THREE_DOLLARS = 3;
	
	public static final int FOUR_DOLLARS = 4;
	
	public static final int FIVE_DOLLARS = 5;
	
	public static final int ONE_HUNDRED_DOLLARS = 100;
	
	private int amount;
	
	private Money(){
		super();
	}
	
	public Money(String amount){
		this();
		this.amount = Integer.valueOf(amount).intValue();
	}
	
	public Money(int amount){
		this();
		this.amount = amount;
	}
	 
	public static int calculateWinnings(int initialBet, int payOut){
		return initialBet * payOut;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
