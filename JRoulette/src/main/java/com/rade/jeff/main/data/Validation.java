package com.rade.jeff.main.data;

import com.rade.jeff.main.player.Player;

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
