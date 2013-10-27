package com.rade.jeff.model;

public abstract class LocaleBet {
	
	//TODO possibly pull data and/or methods out for EuropeanBet and AmericanBet and store here
	
	protected static final String ARRAY_DELIMITER = ", ";
	
	private static final String CLASS_NAME = LocaleBet.class.getName();
	
	public boolean isValidBet(String betName, String[] stringArrayOfBets) {
		boolean valid = false;
		
		for(String bet : stringArrayOfBets){ //TODO is this thread-safe?
			if(bet.replaceAll(ARRAY_DELIMITER, "").equalsIgnoreCase(betName.trim().replaceAll(" ", "_"))){
				valid = true;
				break;
			}
		}
		
		return valid;
	}
	
	protected static final Integer NZERO = Integer.valueOf(0);
	protected static final Integer NONE = Integer.valueOf(1);
	protected static final Integer NTWO = Integer.valueOf(2);
	protected static final Integer NTHREE = Integer.valueOf(3);
	protected static final Integer NFOUR = Integer.valueOf(4);
	protected static final Integer NFIVE = Integer.valueOf(5);
	protected static final Integer NSIX = Integer.valueOf(6);
	protected static final Integer NSEVEN = Integer.valueOf(7);
	protected static final Integer NEIGHT = Integer.valueOf(8);
	protected static final Integer NNINE = Integer.valueOf(9);
	protected static final Integer NTEN = Integer.valueOf(10);
	protected static final Integer NELEVEN = Integer.valueOf(11);
	protected static final Integer NTWELVE = Integer.valueOf(12);
	protected static final Integer NTHIRTEEN = Integer.valueOf(13);
	protected static final Integer NFOURTEEN = Integer.valueOf(14);
	protected static final Integer NFIFTEEN = Integer.valueOf(15);
	protected static final Integer NSIXTEEN = Integer.valueOf(16);
	protected static final Integer NSEVENTEEN = Integer.valueOf(17);
	protected static final Integer NEIGHTEEN = Integer.valueOf(18);
	protected static final Integer NNINETEEN = Integer.valueOf(19);
	protected static final Integer NTWENTY = Integer.valueOf(20);
	protected static final Integer NTWENTY_ONE = Integer.valueOf(21);
	protected static final Integer NTWENTY_TWO = Integer.valueOf(22);
	protected static final Integer NTWENTY_THREE = Integer.valueOf(23);
	protected static final Integer NTWENTY_FOUR = Integer.valueOf(24);
	protected static final Integer NTWENTY_FIVE = Integer.valueOf(25);
	protected static final Integer NTWENTY_SIX = Integer.valueOf(26);
	protected static final Integer NTWENTY_SEVEN = Integer.valueOf(27);
	protected static final Integer NTWENTY_EIGHT = Integer.valueOf(28);
	protected static final Integer NTWENTY_NINE = Integer.valueOf(29);
	protected static final Integer NTHIRTY = Integer.valueOf(30);
	protected static final Integer NTHIRTY_ONE = Integer.valueOf(31);
	protected static final Integer NTHIRTY_TWO = Integer.valueOf(32);
	protected static final Integer NTHIRTY_THREE = Integer.valueOf(33);
	protected static final Integer NTHIRTY_FOUR = Integer.valueOf(34);
	protected static final Integer NTHIRTY_FIVE = Integer.valueOf(35);
	protected static final Integer NTHIRTY_SIX = Integer.valueOf(36);
	protected static final Integer NTHIRTY_SEVEN = Integer.valueOf(37);

}
