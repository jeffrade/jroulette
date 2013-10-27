package com.rade.jeff.player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.rade.jeff.model.Bet;

public class Player implements Serializable{

	private static final long serialVersionUID = 38457832583295732L;
	
	private PlayerBank playerBank;
	
	private boolean playingDecision;
	
	private List<Bet> playerBets;
	
	private List<Bet> lastPlayerBets;

	private boolean undecided;
	
	private String name;
	
	public Player(List<Bet> listOfBets){
		super();
		this.playingDecision = true;
		this.undecided = false;
		this.playerBets = listOfBets;
		this.lastPlayerBets = new ArrayList<Bet>();
	}
	
	public Player(){
		super();
		this.playingDecision = true;
		this.playerBets = new ArrayList<Bet>();
		this.lastPlayerBets = new ArrayList<Bet>();
	}
	
	public Player(String playerName) {
		this();
		name = playerName;
	}

	public void setPlayerBank(PlayerBank playerBank) {
		playerBank.setPlayer(this);
		this.playerBank = playerBank;
	}

	public PlayerBank getPlayerBank() {
		return playerBank;
	}

	public boolean getPlayingDecision() {
		return playingDecision;
	}

	public void setPlayingDecision(boolean playingDecision) {
		this.playingDecision = playingDecision;
		this.undecided = false;
	}

	public List<Bet> getPlayerBets() {
		return playerBets;
	}

	public void setPlayerBets(List<Bet> playerBets) {
		this.playerBets = playerBets;
	}

	public void setLastPlayerBets(List<Bet> lastPlayerBets) {
		this.lastPlayerBets = lastPlayerBets;
	}

	public List<Bet> getLastPlayerBets() {
		return lastPlayerBets;
	}

	public void clearPlayerBets() {
		if(!playerBets.isEmpty()){
			lastPlayerBets.clear();
			lastPlayerBets.addAll(playerBets);
			playerBets.clear();
		}
	}

	public void setUndecided(boolean undecided) {
		this.undecided = undecided;
	}
	
	public boolean getUndecided(){
		return this.undecided;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
