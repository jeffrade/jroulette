package com.rade.jeff.player;

import java.io.Serializable;
import java.util.List;

import com.rade.jeff.model.Bet;
import com.rade.jeff.model.Money;

public class PlayerBank implements Serializable{

	/**
	 * Default
	 */
	private static final long serialVersionUID = 1L;

	private Player player;
	
	private int initialBet;
	
	private int moneyWon;
	
	private int initialMoney;
	
	private int totalMoney;
	
	public static final int MAKING_OR_LOST_BET = -1;

	public static final int WON_BET = 1;
	
	private PlayerBank(){
		super();
	}
	
	public PlayerBank(int initialMoney){
		this();
		this.initialMoney = initialMoney;
		this.totalMoney = initialMoney;
	}
	
	public PlayerBank(Money money){
		this();
		this.initialMoney = money.getAmount();
		this.totalMoney = money.getAmount();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getInitialBet() {
		return initialBet;
	}

	public void setInitialBet(int initialBet) {
		this.initialBet = initialBet;
	}

	public int getMoneyWon() {
		return moneyWon;
	}

	public void setMoneyWon(int moneyWon) {
		this.moneyWon = moneyWon;
	}
	
	//TODO Where else would these rules be, besides in front-end validation?
	public void addMoney(int money, int wonOrLost){
		if(wonOrLost == MAKING_OR_LOST_BET && (totalMoney == 0 || money > this.totalMoney)){
			System.out.println("##########################################################");
			System.out.println("### BUG: You do not have enough money to make that bet ###");
			System.out.println("##########################################################");
		} else if(wonOrLost == MAKING_OR_LOST_BET && totalMoney == 0){
			//TODO is this block ever executed?
			System.out.println("#####################################");
			System.out.println("### Does this block get executed? ###");
			System.out.println("#####################################");
			this.player.setPlayingDecision(false);
			this.player.setUndecided(false);
		} else{
			this.totalMoney += money * wonOrLost;
			this.moneyWon += money * wonOrLost;
		}
		
		if(totalMoney == 0){
			System.out.println("WARNING: You have $0");
		}
	}
	
	public void addMoney(List<Bet> listOfBets, int wonOrLost){
		for(Bet bet : listOfBets){
			addMoney(bet.getAmount(), wonOrLost);
		}
	}

	public int getInitialMoney() {
		return initialMoney;
	}

	public void setInitialMoney(int initialMoney) {
		this.setInitialMoney(initialMoney, true);
	}
	
	public void setInitialMoney(int initialMoney, boolean setTotalMoney){
		this.initialMoney = initialMoney;
		if(setTotalMoney){
			this.totalMoney = initialMoney;
		}
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public boolean hasNoMoney(){
		return totalMoney == 0;
	}

}
