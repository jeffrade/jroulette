package com.rade.jeff.model;

import com.rade.jeff.player.Player;

public class RouletteWheelStatistics {
		
	private RouletteWheelStatistics(){
		super();
	}
	
	public synchronized static void printResults(Player player){
		System.out.println("Money won " + player.getPlayerBank().getMoneyWon() + " for player " + player);
		System.out.println("Total money " + player.getPlayerBank().getTotalMoney() + " for player " + player);
	}

}