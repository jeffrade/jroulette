package com.rade.jeff;

import junit.framework.TestCase;

import com.rade.jeff.player.PlayerBank;

public class PlayerBankTest extends TestCase {
	
	public void testAddMoney(){
		PlayerBank bank = new PlayerBank(10);
		bank.addMoney(9, PlayerBank.MAKING_OR_LOST_BET);
		assertEquals(10 - 9, bank.getTotalMoney());
		bank.addMoney(1, PlayerBank.MAKING_OR_LOST_BET);
		assertEquals(0, bank.getTotalMoney()); //game over
		bank.setInitialMoney(10, true); //playing again :)
		bank.addMoney(11, PlayerBank.MAKING_OR_LOST_BET); //invalid Bet
		assertEquals(10, bank.getTotalMoney()); //nothing should of happened, initial money should = 10
		bank.addMoney(10, PlayerBank.WON_BET);
		assertEquals(10 + 10, bank.getTotalMoney());
	}
	
}
