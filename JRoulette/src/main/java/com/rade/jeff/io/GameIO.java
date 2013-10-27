package com.rade.jeff.io;

public interface GameIO {
	
	public String getBet(String message, String[] betChoices);
	
	public int getBetAmount(String message, String bet);

	public boolean hasAnotherBet(String message);
	
	public int getBetAmountAndValidate(String message, String bet, int validator);

	public String promptPlayAgain(String message, String[] object, String object2);
	
	public String displayMessageAndGetInput(String message, String[] object, String object2);
	
	public void messageToUser(String message);

}
