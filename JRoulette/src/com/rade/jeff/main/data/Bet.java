package com.rade.jeff.main.data;

import java.util.Set;

public interface Bet {
	
	/**
	 * Return String array of Choices for this type of Bet
	 * @return
	 */
	public String[] getBetChoices();

	/**
	 * Set the bet variable with a Set of Integers
	 * @param bet
	 */
	public void setBet(Set<Integer> bet);
	
	/**
	 * Get the Set of Integers that make up a bet
	 * @return
	 */
	public Set<Integer> getBet();
	
	/**
	 * 
	 * @return
	 */
	public int getAmount();

	/**
	 * 
	 * @param amount
	 */
	public void setAmount(int amount);

	/**
	 * 
	 * @return
	 */
	public String[] getArrayOfBets();
	
	/**
	 * 
	 * @return
	 */
	public String getBetName();
	
	/**
	 * 
	 * @param betName
	 */
	public void setBetName(String betName);
	
	/**
	 * 
	 * @param betName
	 * @return boolean
	 */
	public boolean isValidBet(String betName);
	
}
