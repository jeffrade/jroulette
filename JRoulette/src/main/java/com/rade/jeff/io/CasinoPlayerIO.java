package com.rade.jeff.io;

import com.rade.jeff.io.UserIO;
import com.rade.jeff.util.JRouletteUtil;

public class CasinoPlayerIO implements GameIO{
	
	public CasinoPlayerIO(){
		super();
	}

	public String getBet(String message, String[] betChoices) {
		String bet = UserIO.getInstance().userCommunicationHub(message, betChoices, null);
		bet = JRouletteUtil.cleanBetName(bet);
		return bet;
	}
	
	public int getBetAmount(String message, String bet){
		message = message.replaceFirst("xxx", bet);
		String amount = UserIO.getInstance().userCommunicationHub(message, null, null);
		return Integer.valueOf(amount).intValue();
	}

	public boolean hasAnotherBet(String message) {
		String hasAnotherBet = UserIO.getInstance().userCommunicationHub(message, null, null);
		return hasAnotherBet.equalsIgnoreCase("Y") ? true : false;
	}
	
	public int getBetAmountAndValidate(String message, String bet, int validator){
		message = message.replace("xxx", bet);
		String amount = UserIO.getInstance().userCommunicationHubIntValidation(message, null, null, validator, UserIO.LESS_THAN_EQUAL);
		return Integer.valueOf(amount).intValue();
	}

	public String promptPlayAgain(String message, String[] object, String object2) {
		return UserIO.getInstance().userCommunicationHub(message, object, object2);
	}
	
	public String displayMessageAndGetInput(String message, String[] object, String object2) {
		return UserIO.getInstance().userCommunicationHub(message, object, object2);
	}
	
	public void messageToUser(String message){
		UserIO.getInstance().printMessageToUser(message);
	}

}
