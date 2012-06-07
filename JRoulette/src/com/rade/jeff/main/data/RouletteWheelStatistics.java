package com.rade.jeff.main.data;

import com.rade.jeff.main.player.Player;

public class RouletteWheelStatistics {
		
	private RouletteWheelStatistics(){
		super();
	}
	
	public synchronized static void printResults(Player player){
		System.out.println("Money won " + player.getPlayerBank().getMoneyWon() + " for player " + player);
		System.out.println("Total money " + player.getPlayerBank().getTotalMoney() + " for player " + player);
	}

}