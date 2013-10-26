package com.rade.jeff.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.rade.jeff.main.data.AmericanBet;
import com.rade.jeff.main.data.AmericanOddsImpl;
import com.rade.jeff.main.data.Bet;
import com.rade.jeff.main.data.BetFactory;
import com.rade.jeff.main.data.EuropeanBet;
import com.rade.jeff.main.data.EuropeanOddsImpl;
import com.rade.jeff.main.data.Odds;
import com.rade.jeff.main.data.Ratio;
import com.rade.jeff.main.data.AmericanBet.AmericanTypeOfBet;
import com.rade.jeff.main.data.EuropeanBet.EuropeanTypeOfBet;
import com.rade.jeff.main.player.Player;
import com.rade.jeff.main.player.PlayerBank;

public class JRouletteGame implements Serializable{

	private static final long serialVersionUID = 9325983722209583L;
	
	private static final String CLASS_NAME = JRouletteGame.class.getName();
	
	private static final Logger LOG = Logger.getLogger(CLASS_NAME);

	public static final String PLAY_AGAIN_MESSAGE = "Do you want to play again [y or n]?";
	
	public static final String WELCOME_MESSAGE = "Welcome to JRoulette!  Press ENTER to play";

	public static final String INITIAL_MONEY_MESSAGE = "How much money do you want to play with today?";

	public static final String WHEEL_MESSAGE = "Do you want to play an American Wheel or European Wheel [American = 1 or European = 2]?";

	public static final String ENTER_NAME_MESSAGE = "Please enter your name:";
	
	public static final String THANKYOU_MESSAGE = "Thanks for playing!";
	
	public static final String CHOOSE_BET_MESSAGE = "Type a bet from the following below:";
	
	public static final String HOW_MUCH_MESSAGE = "How much do you want to bet on xxx (Enter '0' to CANCEL)?";
	
	public static final String ANOTHER_BET_MESSAGE = "Do you want to make another bet [y or n]?";
	
	public static final String REMOVE_BET_MESSAGE = "Would you like to remove a bet from the table [y or n]?";
	
	public static final String CHOOSE_A_BET_TO_REMOVE = "Please type the bet and amount that you would like to remove [bet, amount]:";
	
	public static final String BET_NOT_FOUND = "That bet was not found";

	private static final String SPACE = " ";

	private static final String PIPE = "|";
	
	private static final String _37 = "37";
	
	private static final String _00 = "00";
	
	/**
	 * Default Constructor
	 */
	public JRouletteGame(){
		super();
	}
	
	/**
	 * 
	 * @param casino
	 * @param player
	 * @param spinResult
	 * @return
	 */
	public String payOutBetsToPlayers(Casino casino, Player player, int spinResult){
		return casino.payOutBets(player, spinResult);
	}
	
	/**
	 * 
	 * @param casino
	 * @return
	 */
	public int spinRouletteWheel(Casino casino){
		return casino.spinWheel();
	}
	
	/**
	 * Being used by JRouletteWeb Ajax call
	 * @param casino
	 * @return
	 */
	public String getColorAndNumberHistory(Casino casino){
		StringBuilder s = new StringBuilder();
		
		List<String> c = casino.getHistory().getColors();
		List<String> n = casino.getHistory().getNumbers();
		
		for(int i = 0; i < c.size(); i++){
			s.append(c.get(i).trim().substring(0, 1));
			s.append(n.get(i).trim().replace(_37, _00));
			s.append(PIPE);
		}
		
		//LOG.logp(Level.INFO, CLASS_NAME, "getColorAndNumberHistory()", "color and number history", s.toString()); //s.toString() does not get printed out
		
		return s.toString();
	}
	
	/**
	 * 
	 * @param casino
	 * @return
	 */
	public String getLastNumber(Casino casino){
		return casino.getHistory().getLastNumber();
	}
	
	/**
	 * 
	 * @param casino
	 * @return
	 */
	public List<String> getNumberHistoryList(Casino casino){
		return casino.getHistory().getNumbers();
	}
	
	/**
	 * 
	 * @param casino
	 * @return
	 */
	public String getNumberHistoryString(Casino casino){
		StringBuilder message = new StringBuilder();
		for(String number : casino.getHistory().getNumbers()){
			message.append(number);
			message.append(SPACE);
		}
		return message.toString();
	}
	
	/**
	 * 
	 * @param casino
	 * @return
	 */
	public String getLastColor(Casino casino){
		return casino.getHistory().getLastColor();
	}
	
	/**
	 * 
	 * @param casino
	 * @return
	 */
	public List<String> getColorHistoryList(Casino casino){
		return casino.getHistory().getColors();
	}
	
	/**
	 * 
	 * @param casino
	 * @return
	 */
	public String getColorHistoryString(Casino casino){
		StringBuilder message = new StringBuilder();
		for(String color : casino.getHistory().getColors()){
			message.append(color);
			message.append(SPACE);
		}
		return message.toString();
	}
	
	/**
	 * 
	 * @param casino
	 * @param player
	 * @return
	 */
	public boolean casinoHasPlayers(Casino casino, Player player){
		return casino.nextGameHasPlayer(player);
	}
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public boolean isPlayerAbleToBet(Player player){
		return !player.getPlayerBank().hasNoMoney();
	}
	
	public boolean isPlayerAbleToBet(Player player, String betAmount){
		return player.getPlayerBank().getTotalMoney() >= Integer.valueOf(betAmount).intValue();
	}
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public boolean isPlayerWantingToBet(Player player){
		return player.getPlayingDecision();
	}

	/**
	 * 
	 * @param player
	 * @param bet
	 */
	public void makeBet(Player player, Bet bet){
		if(bet != null){
			player.getPlayerBets().add(bet);
			subtractMoneyFromBank(player, bet.getAmount());
		} else{
			LOG.logp(Level.INFO, CLASS_NAME, "makeBet()", "bet argument is null", player);
		}
	}
	
	private void subtractMoneyFromBank(Player player, int amount){
		player.getPlayerBank().addMoney(amount, PlayerBank.MAKING_OR_LOST_BET);
	}
	
	/**
	 * 
	 * @param player
	 * @return returns true if lastPlayerBets object is not empty 
	 */
	public boolean repeatBets(Player player){
		player.getPlayerBets().addAll(player.getLastPlayerBets());
		
		for(int i = 0; i < player.getPlayerBets().size(); i++){
			subtractMoneyFromBank(player, player.getPlayerBets().get(i).getAmount());
		}
		
		return !player.getLastPlayerBets().isEmpty();
	}
	
	/**
	 * 
	 * @param betName
	 * @param numberWheelCount
	 * @return
	 */
	public boolean isValidBetName(String betName, int numberWheelCount){
		return BetFactory.getBetByLocale(numberWheelCount).isValidBet(betName);
	}
	
	/**
	 * 
	 * @param totalMoney
	 * @param betName
	 * @param amount
	 * @param numberWheelCount
	 * @return
	 */
	public Bet getBet(int totalMoney, String betName, int amount, int numberWheelCount){
		Bet bet = null;		
		if(amount > 0){
			bet = BetFactory.getBetByLocale(numberWheelCount, betName, amount);
		}
		return bet;
	}
	
	/**
	 * 
	 * @param player
	 * @param playAgain
	 */
	public void setPlayerPlayingAgain(Player player, boolean playAgain){
		if(player.getUndecided() && !player.getPlayerBank().hasNoMoney()){ 
			player.setPlayingDecision(playAgain);
		}
	}
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public String endPlayerGame(Player player){
		player.setPlayingDecision(false);
		boolean lost = player.getPlayerBank().getMoneyWon() < 0;
		return "You " + (lost ? "lost" : "won") + " $" + Math.abs(player.getPlayerBank().getMoneyWon()) + " and have $" + player.getPlayerBank().getTotalMoney() + " left.\n" + THANKYOU_MESSAGE;
	}
	
	/**
	 * 
	 * @param player
	 */
	public void clearPlayerBets(Player player){
		player.clearPlayerBets();
	}
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public List<Bet> getPlayerBets(Player player){
		return player.getPlayerBets();
	}
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public String getPlayerBetsStrings(Player player){
		List<Bet> bets = getPlayerBets(player);
		StringBuilder stringBets = new StringBuilder();
		for(Bet bet : bets){
			stringBets.append(bet.getBetName());
			stringBets.append(", ");
			stringBets.append(bet.getAmount());
			stringBets.append("\n");
		}
		
		return stringBets.toString();
	}
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public String getPlayerBetsHTML(Player player){
		List<Bet> bets = getPlayerBets(player);
		StringBuilder stringBets = new StringBuilder();
		for(Bet bet : bets){
			stringBets.append("$");
			stringBets.append(bet.getAmount());
			stringBets.append(" on ");
			stringBets.append(bet.getBetName().replaceAll("_", " ").toUpperCase());
			stringBets.append("<br/>&nbsp;");
		}
		
		return stringBets.toString();
	}
	
	/**
	 * 
	 * @param player
	 * @param betName
	 * @param amount
	 * @return
	 */
	public boolean deletePlayerBet(Player player, String betName, String amount){
		List<Bet> bets = player.getPlayerBets();
		Bet bet = null;
		boolean found = false;
		for(Iterator<Bet> itr = bets.iterator(); itr.hasNext();){
			bet = itr.next();
			if(bet.getBetName().equalsIgnoreCase(betName) && bet.getAmount() == Integer.valueOf(amount).intValue()){
				itr.remove();
				player.getPlayerBank().addMoney(bet.getAmount(), PlayerBank.WON_BET); //casino giving money back to player
				found = true;
				break;
			}
		}
		
		return found;
	}
	
	/**
	 * 
	 * @param player Player object
	 * @return returns true if there were bets to delete
	 */
	public boolean deleteAllPlayerBets(Player player){ //This will just delete bets that a player has made
		Bet bet = null;
		boolean r = player.getPlayerBets().isEmpty();
		for(Iterator<Bet> itr = player.getPlayerBets().iterator(); itr.hasNext();){
			bet = itr.next();
			itr.remove();
			player.getPlayerBank().addMoney(bet.getAmount(), PlayerBank.WON_BET); //casino giving money back to player
		}
		
		return !r;
	}
	
	/**
	 * 
	 * @param b bet name
	 * @return int representing the winning ratio of a bet 
	 */
	public int getPayoutRatio(String b){
		return Ratio.getRatio(b);
	}
	
	/**
	 * 
	 * @param b
	 * @param wheelCount
	 * @return
	 */
	public double getOdds(String b, int wheelCount){
		Odds o = wheelCount == 37 ? new EuropeanOddsImpl() : new AmericanOddsImpl();
		double d = 0;
		try{
			d = o.getOdds(b);
		} catch(Exception e){
			LOG.logp(Level.INFO, CLASS_NAME, "getOdds", "error when trying to retrieve odds for bet " + b, e);
		}
		return d;
	}
	
	/**
	 * 
	 * @param b
	 * @param wheelCount
	 * @return
	 */
	public String getOddsAndPayoutString(String b, int wheelCount){
		StringBuilder s = new StringBuilder();
		s.append(b);
		s.append("<br/>Payout: ");
		s.append(getPayoutRatio(b));
		s.append(" to 1<br/>");
		s.append("Odds: 1 in ");
		s.append(getOdds(b, wheelCount));
		//LOG.logp(Level.INFO, CLASS_NAME, "getOddsAndPayoutString()", "Odds and Payout for bet " + b + " = ", s.toString());
		return s.toString();
	}
	
	public String getOddsAndPayoutString(int wheelCount){
		StringBuilder s = new StringBuilder(PIPE);
		List<String> l = new ArrayList<String>();
		
		if(wheelCount == 38){
			AmericanTypeOfBet[] bets = AmericanBet.AmericanTypeOfBet.values();
			for(AmericanTypeOfBet bet : bets){
				l.add(bet.toString());
			}
		} else {
			EuropeanTypeOfBet[] bets = EuropeanBet.EuropeanTypeOfBet.values();
			for(EuropeanTypeOfBet bet : bets){
				l.add(bet.toString());
			}
		}
		
		for(String b : l){
			s.append(b);
			s.append("<br/>Payout: ");
			s.append(getPayoutRatio(b));
			s.append(" to 1<br/>");
			s.append("Odds: 1 in ");
			s.append(getOdds(b, wheelCount));
			s.append(PIPE);
		}

		return s.toString();
	}

}