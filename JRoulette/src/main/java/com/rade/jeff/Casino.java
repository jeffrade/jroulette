package com.rade.jeff;

import java.io.Serializable;

import com.rade.jeff.model.Bet;
import com.rade.jeff.model.Ratio;
import com.rade.jeff.model.RollHistoryBucket;
import com.rade.jeff.model.RollResult;
import com.rade.jeff.model.RouletteWheel;
import com.rade.jeff.player.Player;
import com.rade.jeff.player.PlayerBank;

public class Casino implements Serializable{

	/**
	 * Default
	 */
	private static final long serialVersionUID = 19032434895897132L;

	private static final int GIVE_BACK_ORIG_BET_AMOUNT = 1;

	private RouletteWheel rouletteWheel;
	
	private boolean hasPlayers;
	
	private RollHistoryBucket history;
	
	public Casino(){
		super();
		hasPlayers = true;
		this.history = new RollHistoryBucket();
	}

	public int spinWheel() {
		RollResult result = rouletteWheel.spin();
		this.history.addNumber(result.getNumber());
		this.history.addColor(result.getColor());
		return result.getNumber();
	}
	
	private String executePayOut(Player player, int spinResult){
		StringBuilder message = new StringBuilder();
		for(int i = 0; i < player.getPlayerBets().size(); i++){
			Bet bet = player.getPlayerBets().get(i);
			if(bet.getBet().contains(spinResult)){
				message.append("Your bet of ");
				message.append(bet.getBetName().toLowerCase().replace("_", " "));
				message.append(" won\n");
				int ratio = Ratio.getRatio(bet.getBetName());
				int amt = bet.getAmount();
				int won = (ratio + GIVE_BACK_ORIG_BET_AMOUNT) * amt;
				player.getPlayerBank().addMoney(won, PlayerBank.WON_BET);
			} else{
				message.append("Your bet of ");
				message.append(bet.getBetName().toLowerCase().replace("_", " "));
				message.append(" lost\n");
			}			
		}
		
		return message.toString();
	}
	
	public boolean nextGameHasPlayer(Player player){
		return getPlayerDecision(player);
	}
	
	private boolean getPlayerDecision(Player player) {
		boolean collectiveDecision = false;
		
		if(player.getPlayingDecision()){
			collectiveDecision = true;
		}
		
		return collectiveDecision;
	}
	
	/**
	 * |SpinResult|bet_1 [Won Lost]<br/>...bet_i [Won Lost]<br/>|PlayerMoney
	 * 
	 * @param player
	 * @param spinResult
	 * @return
	 */
	public String payOutBets(Player player, int spinResult){
		String payOutMessage = this.executePayOut(player, spinResult);
		StringBuilder message = new StringBuilder("|");
		message.append(spinResult);
		message.append("|");
		message.append(payOutMessage);
		message.append("|");
		message.append(player.getPlayerBank().getTotalMoney());
		player.setUndecided(true);
		
		return message.toString();
	}

	public RouletteWheel getRouletteWheel() {
		return rouletteWheel;
	}

	public void setRouletteWheel(RouletteWheel rouletteWheel) {
		this.rouletteWheel = rouletteWheel;
	}

	public void setHasPlayers(boolean hasPlayers){
		this.hasPlayers = hasPlayers;
	}
	
	public boolean getHasPlayers(){
		return this.hasPlayers;
	}

	public RollHistoryBucket getHistory() {
		return history;
	}

	public void setHistory(RollHistoryBucket history) {
		this.history = history;
	}

}
