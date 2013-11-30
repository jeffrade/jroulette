package com.rade.jeff;

import com.rade.jeff.io.CasinoPlayerIO;
import com.rade.jeff.io.GameIO;
import com.rade.jeff.model.Bet;
import com.rade.jeff.model.BetFactory;
import com.rade.jeff.model.JRouletteBean;
import com.rade.jeff.model.Money;
import com.rade.jeff.model.RandomNumberGeneratorImpl;
import com.rade.jeff.model.RouletteWheel;
import com.rade.jeff.player.Player;
import com.rade.jeff.player.PlayerBank;

public class JRouletteRunner {
	
	public static void main(String[] args) {
		JRouletteGame newGame = new JRouletteGame();
		JRouletteRunner runner = new JRouletteRunner();
		JRouletteBean bean = initBean();
		runner.beginGameController(bean, newGame);
	}
	
	private void beginGameController(JRouletteBean bean, JRouletteGame game){
		String _message;
		boolean _decision;
		int _int;
		makeBets(bean.getPlayer(), game, bean.getIo(), bean.getNumberWheelCount());
		while(game.casinoHasPlayers(bean.getCasino(), bean.getPlayer())){
			_int = game.spinRouletteWheel(bean.getCasino());
			_message = game.payOutBetsToPlayers(bean.getCasino(), bean.getPlayer(), _int);
			bean.getIo().messageToUser(_message);			
			_message = game.getNumberHistoryJson(bean.getCasino());
			bean.getIo().messageToUser(_message);
			_message = game.getColorHistoryJson(bean.getCasino());
			bean.getIo().messageToUser(_message);
			game.clearPlayerBets(bean.getPlayer());
			_decision = game.isPlayerAbleToBet(bean.getPlayer()) && game.isPlayerWantingToBet(bean.getPlayer()) && bean.getIo().promptPlayAgain(JRouletteGame.PLAY_AGAIN_MESSAGE, null, null).equalsIgnoreCase("y") ? true : false;
			game.setPlayerPlayingAgain(bean.getPlayer(), _decision);
			_decision = game.isPlayerAbleToBet(bean.getPlayer()) && game.isPlayerWantingToBet(bean.getPlayer());
			
			if(_decision){
				_message = makeBets(bean.getPlayer(), game, bean.getIo(), bean.getNumberWheelCount());
				bean.getIo().messageToUser(_message);
			} else{
				bean.getPlayer().setPlayingDecision(false);
				_message = game.getGameEndedMessageJson(bean.getPlayer());
				bean.getIo().messageToUser(_message);
			}
		}
	}

	public String makeBets(Player player, JRouletteGame game, GameIO io, int numberWheelCount){
		boolean anotherBet = true;
		boolean validBet;
		int amount;
		String betName;

		while(anotherBet){
			validBet = false;
			while(!validBet){
				betName = io.getBet(JRouletteGame.CHOOSE_BET_MESSAGE, BetFactory.getBetArrayByLocale(numberWheelCount));
				if(game.isValidBetName(betName, numberWheelCount)){
					validBet = true;
					amount = io.getBetAmountAndValidate(JRouletteGame.HOW_MUCH_MESSAGE, betName, player.getPlayerBank().getTotalMoney());
					Bet bet = game.getBet(player.getPlayerBank().getTotalMoney(), betName, amount, numberWheelCount);
					game.makeBet(player, bet);
				} else{
					io.messageToUser(JRouletteGame.BET_NOT_FOUND);
				}
			}
			anotherBet = game.isPlayerAbleToBet(player) && game.isPlayerWantingToBet(player) && io.hasAnotherBet(JRouletteGame.ANOTHER_BET_MESSAGE);
		}
		
		removeBets(player, game, io);
		
		return "";
	}
	
	public static void removeBets(Player player, JRouletteGame game, GameIO io){
		String _message;
		boolean removeBet, _isDeleted;
		_message = io.displayMessageAndGetInput(JRouletteGame.REMOVE_BET_MESSAGE, null, null);
		removeBet = _message.equalsIgnoreCase("y") ? true : false;
		while(removeBet){
			_isDeleted = false;
			while(!_isDeleted){
				_message = game.getPlayerBetsStrings(player);
				io.messageToUser(_message);
				_message = io.displayMessageAndGetInput(JRouletteGame.CHOOSE_A_BET_TO_REMOVE, null, null);
				_isDeleted = game.deletePlayerBet(player, _message.replace(" ", "").substring(0, _message.replace(" ", "").indexOf(",")), _message.replace(" ", "").substring(_message.replace(" ", "").indexOf(",") + 1, _message.replace(" ", "").length()));
				if(!_isDeleted){
					io.messageToUser("That bet and amount is not found, try again...");
				}
			}
			_message = io.displayMessageAndGetInput(JRouletteGame.REMOVE_BET_MESSAGE, null, null);
			removeBet = _message.equalsIgnoreCase("y") ? true : false;
		}
	}
	
	public static Player createPlayer(String playerName, String initialMoney){
		Player player = new Player(playerName);
		PlayerBank playerBank = new PlayerBank(new Money(initialMoney));
		playerBank.setPlayer(player);
		player.setPlayerBank(playerBank);	
		return player;
	}

	private static JRouletteBean initBean() {
		JRouletteBean bean = new JRouletteBean();
		bean.setCasino(new Casino());
		bean.setIo(new CasinoPlayerIO());
		
		bean.getIo().displayMessageAndGetInput(JRouletteGame.WELCOME_MESSAGE, null, null);
		String money = bean.getIo().displayMessageAndGetInput(JRouletteGame.INITIAL_MONEY_MESSAGE, null, null);
		String name = bean.getIo().displayMessageAndGetInput(JRouletteGame.ENTER_NAME_MESSAGE, null, null);
		Player player = createPlayer(name, money);
		bean.setPlayer(player);
		String _message = bean.getIo().displayMessageAndGetInput(JRouletteGame.WHEEL_MESSAGE, null, null);
		int numberWheelCount = _message.equalsIgnoreCase("1") ? RouletteWheel.AMERICAN_NUMBERS : RouletteWheel.EUROPEAN_NUMBERS;
		bean.setNumberWheelCount(numberWheelCount);
		bean.getCasino().setRouletteWheel(new RouletteWheel(new RandomNumberGeneratorImpl(), numberWheelCount));
		
		return bean;
	}

}
