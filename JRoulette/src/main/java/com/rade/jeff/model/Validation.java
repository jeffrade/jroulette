package com.rade.jeff.model;

import com.rade.jeff.player.Player;

public class Validation {
	
	private Validation(){
		super();
	}
	
	public synchronized static boolean playerHasEnoughMoney(Player player, int amount){
		return playerHasMoney(player) && amount <= player.getPlayerBank().getTotalMoney();
	}
	
	public synchronized static boolean playerHasMoney(Player player){
		return 0 < player.getPlayerBank().getTotalMoney();
	}

}
