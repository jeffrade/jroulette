/**
 * Class to hold the type of bet a <code>Player</code> is making
 */
package com.rade.jeff.model;

import java.util.HashSet;
import java.util.Set;

public class EuropeanBet extends LocaleBet implements Bet{
	
	public enum EuropeanTypeOfBet{
		BLACK,
		RED,
		ODDS,
		EVENS,
		ZERO,
		FIRST_18,
		LAST_18,
		FIRST_DOZEN,
		SECOND_DOZEN,
		THIRD_DOZEN,
		FIRST_COLUMN,
		SECOND_COLUMN,
		THIRD_COLUMN,
		ONE,
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		ELEVEN,
		TWELVE,
		THIRTEEN,
		FOURTEEN,
		FIFTEEN,
		SIXTEEN,
		SEVENTEEN,
		EIGHTEEN,
		NINETEEN,
		TWENTY,
		TWENTY_ONE,
		TWENTY_TWO,
		TWENTY_THREE,
		TWENTY_FOUR,
		TWENTY_FIVE,
		TWENTY_SIX,
		TWENTY_SEVEN,
		TWENTY_EIGHT,
		TWENTY_NINE,
		THIRTY,
		THRITY_ONE,
		THRITY_TWO,
		THRITY_THREE,
		THRITY_FOUR,
		THRITY_FIVE,
		THRITY_SIX,
		ONE_TWO_SPLIT,
		TWO_THREE_SPLIT,
		FOUR_FIVE_SPLIT,
		FIVE_SIX_SPLIT,
		SEVEN_EIGHT_SPLIT,
		EIGHT_NINE_SPLIT,
		TEN_ELEVEN_SPLIT,
		ELEVEN_TWELVE_SPLIT,
		THIRTEEN_FOURTEEN_SPLIT,
		FOURTEEN_FIFTEEN_SPLIT,
		SIXTEEN_SEVENTEEN_SPLIT,
		SEVENTEEN_EIGHTEEN_SPLIT,
		NINTEEN_TWENTY_SPLIT,
		TWENTY_TWENTY_ONE_SPLIT,
		TWENTY_TWO_TWENTY_THREE_SPLIT,
		TWENTY_THREE_TWENTY_FOUR_SPLIT,
		TWENTY_FIVE_TWENTY_SIX_SPLIT,
		TWENTY_SIX_TWENTY_SEVEN_SPLIT,
		TWENTY_EIGHT_TWETNY_NINE_SPLIT,
		TWENTY_NINE_THIRTY_SPLIT,
		THIRTY_ONE_THIRTY_THRITY_TWO_SPLIT,
		THRITY_TWO_THIRTY_THREE_SPLIT,
		THRITY_FOUR_THIRTY_FIVE_SPLIT,
		THIRTY_FIVE_THIRTY_SIX_SPLIT,
		ONE_FOUR_SPLIT,
		TWO_FIVE_SPLIT,
		THREE_SIX_SPLIT,
		FOUR_SEVEN_SPLIT,
		FIVE_EIGHT_SPLIT,
		SIX_NINE_SPLIT,
		SEVEN_TEN_SPLIT,
		EIGHT_ELEVEN_SPLIT,
		NINE_TWELVE_SPLIT,
		TEN_THIRTEEN_SPLIT,
		ELEVEN_FOURTEEN_SPLIT,
		TWELVE_FIFTEEN_SPLIT,
		THIRTEEN_SIXTEEN_SPLIT,
		FOURTEEN_SEVENTEEN_SPLIT,
		FIFTEEN_EIGHTEEN_SPLIT,
		SIXTEEN_NINETEEN_SPLIT,
		SEVENTEEN_TWENTY_SPLIT,
		EIGHTEEN_TWENTY_ONE_SPLIT,
		NINETEEN_TWENTY_TWO_SPLIT,
		TWENTY_TWENTY_THREE_SPLIT,
		TWENTY_ONE_TWENTY_FOUR_SPLIT,
		TWENTY_TWO_TWENTY_FIVE_SPLIT,
		TWENTY_THREE_TWENTY_SIX_SPLIT,
		TWENTY_FOUR_TWENTY_SEVEN_SPLIT,
		TWENTY_FIVE_TWENTY_EIGHT_SPLIT,
		TWENTY_SIX_TWENTY_NINE_SPLIT,
		TWENTY_SEVEN_THIRTY_SPLIT,
		TWENTY_EIGHT_THIRTY_ONE_SPLIT,
		TWENTY_NINE_THRITY_TWO_SPLIT,
		THIRTY_THIRTY_THREE_SPLIT,
		THIRTY_ONE_THIRTY_FOUR_SPLIT,
		THIRTY_TWO_THIRTY_FIVE_SPLIT,
		THIRTY_THREE_THIRTY_SIX_SPLIT,
		ONE_TWO_THREE_STREET,
		FOUR_FIVE_SIX_STREET,
		SEVEN_EIGHT_NINE_STREET,
		TEN_ELEVEN_TWELVE_STREET,
		THIRTEEN_FOURTEEN_FIFTEEN_STREET,
		SIXTEEN_SEVENTEEN_EIGHTEEN_STREET,
		NINETEEN_TWENTY_TWENTY_ONE_STREET,
		TWENTY_TWO_TWENTY_THREE_TWENTY_FOUR_STREET,
		TWENTY_FIVE_TWENTY_SIX_TWENTY_SEVEN_STREET,
		TWENTY_EIGHT_TWENTY_NINE_THIRTY_STREET,
		THIRTY_ONE_THIRTY_TWO_THIRTY_THREE_STREET,
		THIRTY_FOUR_THRITY_FIVE_THIRTY_SIX_STREET,		
		ONE_2_4_5_CORNER,
		TWO_3_5_6_CORNER,
		FOUR_5_7_8_CORNER,
		FIVE_6_8_9_CORNER,
		SEVEN_8_10_11_CORNER,
		EIGHT_9_11_12_CORNER,
		TEN_11_13_14_CORNER,
		ELEVEN_12_14_15_CORNER,
		THIRTEEN_14_16_17_CORNER,
		FOURTEEN_15_17_18_CORNER,
		SIXTEEN_17_19_20_CORNER,
		SEVENTEEN_18_20_21_CORNER,
		NINETEEN_20_22_23_CORNER,
		TWENTY_21_23_24_CORNER,
		TWENTY_TWO_23_25_26_CORNER,
		TWENTY_THREE_24_26_27_CORNER,
		TWENTY_FIVE_26_28_29_CORNER,
		TWENTY_SIX_27_29_30_CORNER,
		TWENT_EIGHT_29_31_32_CORNER,
		TWENTY_NINE_30_32_33_CORNER,
		THIRTY_ONE_32_34_35_CORNER,
		THIRTY_TWO_33_35_36_CORNER,
		ONE_4_SIXLINE,
		FOUR_7_SIXLINE,
		SEVEN_10_SIXLINE,
		TEN_13_SIXLINE,
		THIRTEEN_16_SIXLINE,
		SIXTEEN_19_SIXLINE,
		NINETEEN_22_SIXLINE,
		TWENTY_TWO_25_SIXLINE,
		TWENTY_FIVE_28_SIXLINE,
		TWENTY_EIGHT_31_SIXLINE,
		THIRTY_ONE_34_SIXLINE,
		ZERO_1_2_TRIO, //EUROPEAN TABLE
		ZERO_2_3_TRIO, //EUROPEAN TABLE
	}
	
	private static final Set<Integer> ODDS = new HashSet<Integer>();
	private static final Set<Integer> EVENS = new HashSet<Integer>();
	private static final Set<Integer> ZERO = new HashSet<Integer>();
	private static final Set<Integer> BLACK = new HashSet<Integer>();
	private static final Set<Integer> RED = new HashSet<Integer>();
	private static final Set<Integer> GREEN_NUMBERS = new HashSet<Integer>();
	private static final Set<Integer> FIRST_COLUMN = new HashSet<Integer>();
	private static final Set<Integer> SECOND_COLUMN = new HashSet<Integer>();
	private static final Set<Integer> THIRD_COLUMN = new HashSet<Integer>();
	private static final Set<Integer> FIRST_DOZEN = new HashSet<Integer>();
	private static final Set<Integer> SECOND_DOZEN = new HashSet<Integer>();
	private static final Set<Integer> THIRD_DOZEN = new HashSet<Integer>();
	private static final Set<Integer> FIRST_18 = new HashSet<Integer>();
	private static final Set<Integer> LAST_18 = new HashSet<Integer>();	
	private static final Set<Integer> ONE = new HashSet<Integer>();
	private static final Set<Integer> TWO = new HashSet<Integer>();
	private static final Set<Integer> THREE = new HashSet<Integer>();
	private static final Set<Integer> FOUR = new HashSet<Integer>();
	private static final Set<Integer> FIVE = new HashSet<Integer>();
	private static final Set<Integer> SIX = new HashSet<Integer>();
	private static final Set<Integer> SEVEN = new HashSet<Integer>();
	private static final Set<Integer> EIGHT = new HashSet<Integer>();
	private static final Set<Integer> NINE = new HashSet<Integer>();
	private static final Set<Integer> TEN = new HashSet<Integer>();
	private static final Set<Integer> ELEVEN = new HashSet<Integer>();
	private static final Set<Integer> TWELVE = new HashSet<Integer>();
	private static final Set<Integer> THIRTEEN = new HashSet<Integer>();
	private static final Set<Integer> FOURTEEN = new HashSet<Integer>();
	private static final Set<Integer> FIFTEEN = new HashSet<Integer>();
	private static final Set<Integer> SIXTEEN = new HashSet<Integer>();
	private static final Set<Integer> SEVENTEEN = new HashSet<Integer>();
	private static final Set<Integer> EIGHTEEN = new HashSet<Integer>();
	private static final Set<Integer> NINETEEN = new HashSet<Integer>();
	private static final Set<Integer> TWENTY = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_ONE = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_TWO = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_THREE = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_FOUR = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_FIVE = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_SIX = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_SEVEN = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_EIGHT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_NINE = new HashSet<Integer>();
	private static final Set<Integer> THIRTY = new HashSet<Integer>();
	private static final Set<Integer> THRITY_ONE = new HashSet<Integer>();
	private static final Set<Integer> THRITY_TWO = new HashSet<Integer>();
	private static final Set<Integer> THRITY_THREE = new HashSet<Integer>();
	private static final Set<Integer> THRITY_FOUR = new HashSet<Integer>();
	private static final Set<Integer> THRITY_FIVE = new HashSet<Integer>();
	private static final Set<Integer> THRITY_SIX = new HashSet<Integer>();
	
	private static final Set<Integer> ONE_TWO_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWO_THREE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> FOUR_FIVE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> FIVE_SIX_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> SEVEN_EIGHT_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> EIGHT_NINE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TEN_ELEVEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> ELEVEN_TWELVE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> THIRTEEN_FOURTEEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> FOURTEEN_FIFTEEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> SIXTEEN_SEVENTEEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> SEVENTEEN_EIGHTEEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> NINTEEN_TWENTY_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_TWENTY_ONE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_TWO_TWENTY_THREE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_THREE_TWENTY_FOUR_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_FIVE_TWENTY_SIX_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_SIX_TWENTY_SEVEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_EIGHT_TWETNY_NINE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_NINE_THIRTY_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> THIRTY_ONE_THIRTY_THRITY_TWO_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> THRITY_TWO_THIRTY_THREE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> THRITY_FOUR_THIRTY_FIVE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> THIRTY_FIVE_THIRTY_SIX_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> ONE_FOUR_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWO_FIVE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> THREE_SIX_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> FOUR_SEVEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> FIVE_EIGHT_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> SIX_NINE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> SEVEN_TEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> EIGHT_ELEVEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> NINE_TWELVE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TEN_THIRTEEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> ELEVEN_FOURTEEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWELVE_FIFTEEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> THIRTEEN_SIXTEEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> FOURTEEN_SEVENTEEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> FIFTEEN_EIGHTEEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> SIXTEEN_NINETEEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> SEVENTEEN_TWENTY_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> EIGHTEEN_TWENTY_ONE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> NINETEEN_TWENTY_TWO_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_TWENTY_THREE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_ONE_TWENTY_FOUR_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_TWO_TWENTY_FIVE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_THREE_TWENTY_SIX_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_FOUR_TWENTY_SEVEN_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_FIVE_TWENTY_EIGHT_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_SIX_TWENTY_NINE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_SEVEN_THIRTY_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_EIGHT_THIRTY_ONE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_NINE_THRITY_TWO_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> THIRTY_THIRTY_THREE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> THIRTY_ONE_THIRTY_FOUR_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> THIRTY_TWO_THIRTY_FIVE_SPLIT = new HashSet<Integer>();
	private static final Set<Integer> THIRTY_THREE_THIRTY_SIX_SPLIT = new HashSet<Integer>();
	
	private static final Set<Integer> ONE_TWO_THREE_STREET = new HashSet<Integer>();
	private static final Set<Integer> FOUR_FIVE_SIX_STREET = new HashSet<Integer>();
	private static final Set<Integer> SEVEN_EIGHT_NINE_STREET = new HashSet<Integer>();
	private static final Set<Integer> TEN_ELEVEN_TWELVE_STREET = new HashSet<Integer>();
	private static final Set<Integer> THIRTEEN_FOURTEEN_FIFTEEN_STREET = new HashSet<Integer>();
	private static final Set<Integer> SIXTEEN_SEVENTEEN_EIGHTEEN_STREET = new HashSet<Integer>();
	private static final Set<Integer> NINETEEN_TWENTY_TWENTY_ONE_STREET = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_TWO_TWENTY_THREE_TWENTY_FOUR_STREET = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_FIVE_TWENTY_SIX_TWENTY_SEVEN_STREET = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_EIGHT_TWENTY_NINE_THIRTY_STREET = new HashSet<Integer>();
	private static final Set<Integer> THIRTY_ONE_THIRTY_TWO_THIRTY_THREE_STREET = new HashSet<Integer>();
	private static final Set<Integer> THIRTY_FOUR_THRITY_FIVE_THIRTY_SIX_STREET = new HashSet<Integer>();

	private static final Set<Integer> ONE_2_4_5_CORNER = new HashSet<Integer>();
	private static final Set<Integer> TWO_3_5_6_CORNER = new HashSet<Integer>();
	private static final Set<Integer> FOUR_5_7_8_CORNER = new HashSet<Integer>();
	private static final Set<Integer> FIVE_6_8_9_CORNER = new HashSet<Integer>();
	private static final Set<Integer> SEVEN_8_10_11_CORNER = new HashSet<Integer>();
	private static final Set<Integer> EIGHT_9_11_12_CORNER = new HashSet<Integer>();
	private static final Set<Integer> TEN_11_13_14_CORNER = new HashSet<Integer>();
	private static final Set<Integer> ELEVEN_12_14_15_CORNER = new HashSet<Integer>();
	private static final Set<Integer> THIRTEEN_14_16_17_CORNER = new HashSet<Integer>();
	private static final Set<Integer> FOURTEEN_15_17_18_CORNER = new HashSet<Integer>();
	private static final Set<Integer> SIXTEEN_17_19_20_CORNER = new HashSet<Integer>();
	private static final Set<Integer> SEVENTEEN_18_20_21_CORNER = new HashSet<Integer>();
	private static final Set<Integer> NINETEEN_20_22_23_CORNER = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_21_23_24_CORNER = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_TWO_23_25_26_CORNER = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_THREE_24_26_27_CORNER = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_FIVE_26_28_29_CORNER = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_SIX_27_29_30_CORNER = new HashSet<Integer>();
	private static final Set<Integer> TWENT_EIGHT_29_31_32_CORNER = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_NINE_30_32_33_CORNER = new HashSet<Integer>();
	private static final Set<Integer> THIRTY_ONE_32_34_35_CORNER = new HashSet<Integer>();
	private static final Set<Integer> THIRTY_TWO_33_35_36_CORNER = new HashSet<Integer>();

	private static final Set<Integer> ONE_4_SIXLINE = new HashSet<Integer>();
	private static final Set<Integer> FOUR_7_SIXLINE = new HashSet<Integer>();
	private static final Set<Integer> SEVEN_10_SIXLINE = new HashSet<Integer>();
	private static final Set<Integer> TEN_13_SIXLINE = new HashSet<Integer>();
	private static final Set<Integer> THIRTEEN_16_SIXLINE = new HashSet<Integer>();
	private static final Set<Integer> SIXTEEN_19_SIXLINE = new HashSet<Integer>();
	private static final Set<Integer> NINETEEN_22_SIXLINE = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_TWO_25_SIXLINE = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_FIVE_28_SIXLINE = new HashSet<Integer>();
	private static final Set<Integer> TWENTY_EIGHT_31_SIXLINE = new HashSet<Integer>();
	private static final Set<Integer> THIRTY_ONE_34_SIXLINE = new HashSet<Integer>();

	private static final Set<Integer> ZERO_1_2_TRIO = new HashSet<Integer>();
	private static final Set<Integer> ZERO_2_3_TRIO = new HashSet<Integer>();
	private static final Set<Integer> ZERO_1_2_BASKET = new HashSet<Integer>();
	
	private static final Set<Integer> TOPLINE = new HashSet<Integer>();
	
	static{
		ZERO.add(NZERO);
		
		ODDS.add(NONE);
		ODDS.add(NTHREE);
		ODDS.add(NFIVE);
		ODDS.add(NSEVEN);
		ODDS.add(NNINE);
		ODDS.add(NELEVEN);
		ODDS.add(NTHIRTEEN);
		ODDS.add(NFIFTEEN);
		ODDS.add(NSEVENTEEN);
		ODDS.add(NNINETEEN);
		ODDS.add(NTWENTY_ONE);
		ODDS.add(NTWENTY_THREE);
		ODDS.add(NTWENTY_FIVE);
		ODDS.add(NTWENTY_SEVEN);
		ODDS.add(NTWENTY_NINE);
		ODDS.add(NTHIRTY_ONE);
		ODDS.add(NTHIRTY_THREE);
		ODDS.add(NTHIRTY_FIVE);
		
		EVENS.add(NTWO);
		EVENS.add(NFOUR);
		EVENS.add(NSIX);
		EVENS.add(NEIGHT);
		EVENS.add(NTEN);
		EVENS.add(NTWELVE);
		EVENS.add(NFOURTEEN);
		EVENS.add(NSIXTEEN);
		EVENS.add(NEIGHTEEN);
		EVENS.add(NTWENTY);
		EVENS.add(NTWENTY_TWO);
		EVENS.add(NTWENTY_FOUR);
		EVENS.add(NTWENTY_SIX);
		EVENS.add(NTWENTY_EIGHT);
		EVENS.add(NTHIRTY);
		EVENS.add(NTHIRTY_TWO);
		EVENS.add(NTHIRTY_FOUR);
		EVENS.add(NTHIRTY_SIX);
		
		BLACK.add(NTWO);
		BLACK.add(NFOUR);
		BLACK.add(NSIX);
		BLACK.add(NEIGHT);
		BLACK.add(NTEN);
		BLACK.add(NELEVEN);
		BLACK.add(NTHIRTEEN);
		BLACK.add(NFIFTEEN);
		BLACK.add(NSEVENTEEN);
		BLACK.add(NTWENTY);
		BLACK.add(NTWENTY_TWO);
		BLACK.add(NTWENTY_FOUR);
		BLACK.add(NTWENTY_SIX);
		BLACK.add(NTWENTY_EIGHT);
		BLACK.add(NTWENTY_NINE);
		BLACK.add(NTHIRTY_ONE);
		BLACK.add(NTHIRTY_THREE);
		BLACK.add(NTHIRTY_FIVE);
		
		RED.add(NONE);
		RED.add(NTHREE);
		RED.add(NFIVE);
		RED.add(NSEVEN);
		RED.add(NNINE);
		RED.add(NTWELVE);
		RED.add(NFOURTEEN);
		RED.add(NSIXTEEN);
		RED.add(NEIGHTEEN);
		RED.add(NNINETEEN);
		RED.add(NTWENTY_ONE);
		RED.add(NTWENTY_THREE);
		RED.add(NTWENTY_FIVE);
		RED.add(NTWENTY_SEVEN);
		RED.add(NTHIRTY);
		RED.add(NTHIRTY_TWO);
		RED.add(NTHIRTY_FOUR);
		RED.add(NTHIRTY_SIX);
		
		GREEN_NUMBERS.add(ZERO.iterator().next());
		
		ONE.add(NONE); 
		TWO.add(NTWO); 
		THREE.add(NTHREE); 
		FOUR.add(NFOUR); 
		FIVE.add(NFIVE); 
		SIX.add(NSIX); 
		SEVEN.add(NSEVEN); 
		EIGHT.add(NEIGHT); 
		NINE.add(NNINE); 
		TEN.add(NTEN); 
		ELEVEN.add(NELEVEN); 
		TWELVE.add(NTWELVE); 
		THIRTEEN.add(NTHIRTEEN); 
		FOURTEEN.add(NFOURTEEN); 
		FIFTEEN.add(NFIFTEEN); 
		SIXTEEN.add(NSIXTEEN); 
		SEVENTEEN.add(NSEVENTEEN); 
		EIGHTEEN.add(NEIGHTEEN); 
		NINETEEN.add(NNINETEEN); 
		TWENTY.add(NTWENTY); 
		TWENTY_ONE.add(NTWENTY_ONE); 
		TWENTY_TWO.add(NTWENTY_TWO); 
		TWENTY_THREE.add(NTWENTY_THREE); 
		TWENTY_FOUR.add(NTWENTY_FOUR); 
		TWENTY_FIVE.add(NTWENTY_FIVE); 
		TWENTY_SIX.add(NTWENTY_SIX); 
		TWENTY_SEVEN.add(NTWENTY_SEVEN); 
		TWENTY_EIGHT.add(NTWENTY_EIGHT); 
		TWENTY_NINE.add(NTWENTY_NINE); 
		THIRTY.add(NTHIRTY); 
		THRITY_ONE.add(NTHIRTY_ONE); 
		THRITY_TWO.add(NTHIRTY_TWO); 
		THRITY_THREE.add(NTHIRTY_THREE); 
		THRITY_FOUR.add(NTHIRTY_FOUR); 
		THRITY_FIVE.add(NTHIRTY_FIVE); 
		THRITY_SIX.add(NTHIRTY_SIX);
		
		//1st Column	1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34
		FIRST_COLUMN.add(NONE);
		FIRST_COLUMN.add(NFOUR);
		FIRST_COLUMN.add(NSEVEN);
		FIRST_COLUMN.add(NTEN);
		FIRST_COLUMN.add(NTHIRTEEN);
		FIRST_COLUMN.add(NSIXTEEN);
		FIRST_COLUMN.add(NNINETEEN);
		FIRST_COLUMN.add(NTWENTY_TWO);
		FIRST_COLUMN.add(NTWENTY_FIVE);
		FIRST_COLUMN.add(NTWENTY_EIGHT);
		FIRST_COLUMN.add(NTHIRTY_ONE);
		FIRST_COLUMN.add(NTHIRTY_FOUR);
		
		//2nd Column	2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35
		SECOND_COLUMN.add(NTWO);
		SECOND_COLUMN.add(NFIVE);
		SECOND_COLUMN.add(NEIGHT);
		SECOND_COLUMN.add(NELEVEN);
		SECOND_COLUMN.add(NFOURTEEN);
		SECOND_COLUMN.add(NSEVENTEEN);
		SECOND_COLUMN.add(NTWENTY);
		SECOND_COLUMN.add(NTWENTY_THREE);
		SECOND_COLUMN.add(NTWENTY_SIX);
		SECOND_COLUMN.add(NTWENTY_NINE);
		SECOND_COLUMN.add(NTHIRTY_TWO);
		SECOND_COLUMN.add(NTHIRTY_FIVE);

		//3rd Column	3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36
		THIRD_COLUMN.add(NTHREE);
		THIRD_COLUMN.add(NSIX);
		THIRD_COLUMN.add(NNINE);
		THIRD_COLUMN.add(NTWELVE);
		THIRD_COLUMN.add(NFIFTEEN);
		THIRD_COLUMN.add(NEIGHTEEN);
		THIRD_COLUMN.add(NTWENTY_ONE);
		THIRD_COLUMN.add(NTWENTY_FOUR);
		THIRD_COLUMN.add(NTWENTY_SEVEN);
		THIRD_COLUMN.add(NTHIRTY);
		THIRD_COLUMN.add(NTHIRTY_THREE);
		THIRD_COLUMN.add(NTHIRTY_SIX);

		FIRST_DOZEN.add(NONE);
		FIRST_DOZEN.add(NTWO);
		FIRST_DOZEN.add(NTHREE);
		FIRST_DOZEN.add(NFOUR);
		FIRST_DOZEN.add(NFIVE);
		FIRST_DOZEN.add(NSIX);
		FIRST_DOZEN.add(NSEVEN);
		FIRST_DOZEN.add(NEIGHT);
		FIRST_DOZEN.add(NNINE);
		FIRST_DOZEN.add(NTEN);
		FIRST_DOZEN.add(NELEVEN);
		FIRST_DOZEN.add(NTWELVE);
		
		SECOND_DOZEN.add(NTHIRTEEN);
		SECOND_DOZEN.add(NFOURTEEN);
		SECOND_DOZEN.add(NFIFTEEN);
		SECOND_DOZEN.add(NSIXTEEN);
		SECOND_DOZEN.add(NSEVENTEEN);
		SECOND_DOZEN.add(NEIGHTEEN);
		SECOND_DOZEN.add(NNINETEEN);
		SECOND_DOZEN.add(NTWENTY);
		SECOND_DOZEN.add(NTWENTY_ONE);
		SECOND_DOZEN.add(NTWENTY_TWO);
		SECOND_DOZEN.add(NTWENTY_THREE);
		SECOND_DOZEN.add(NTWENTY_FOUR);
		
		THIRD_DOZEN.add(NTWENTY_FIVE);
		THIRD_DOZEN.add(NTWENTY_SIX);
		THIRD_DOZEN.add(NTWENTY_SEVEN);
		THIRD_DOZEN.add(NTWENTY_EIGHT);
		THIRD_DOZEN.add(NTWENTY_NINE);
		THIRD_DOZEN.add(NTHIRTY);
		THIRD_DOZEN.add(NTHIRTY_ONE);
		THIRD_DOZEN.add(NTHIRTY_TWO);
		THIRD_DOZEN.add(NTHIRTY_THREE);
		THIRD_DOZEN.add(NTHIRTY_FOUR);
		THIRD_DOZEN.add(NTHIRTY_FIVE);
		THIRD_DOZEN.add(NTHIRTY_SIX);
		
		FIRST_18.add(NONE);
		FIRST_18.add(NTWO);
		FIRST_18.add(NTHREE);
		FIRST_18.add(NFOUR);
		FIRST_18.add(NFIVE);
		FIRST_18.add(NSIX);
		FIRST_18.add(NSEVEN);
		FIRST_18.add(NEIGHT);
		FIRST_18.add(NNINE);
		FIRST_18.add(NTEN);
		FIRST_18.add(NELEVEN);
		FIRST_18.add(NTWELVE);
		FIRST_18.add(NTHIRTEEN);
		FIRST_18.add(NFOURTEEN);
		FIRST_18.add(NFIFTEEN);
		FIRST_18.add(NSIXTEEN);
		FIRST_18.add(NSEVENTEEN);
		FIRST_18.add(NEIGHTEEN);
		
		LAST_18.add(NNINETEEN);
		LAST_18.add(NTWENTY);
		LAST_18.add(NTWENTY_ONE);
		LAST_18.add(NTWENTY_TWO);
		LAST_18.add(NTWENTY_THREE);
		LAST_18.add(NTWENTY_FOUR);
		LAST_18.add(NTWENTY_FIVE);
		LAST_18.add(NTWENTY_SIX);
		LAST_18.add(NTWENTY_SEVEN);
		LAST_18.add(NTWENTY_EIGHT);
		LAST_18.add(NTWENTY_NINE);
		LAST_18.add(NTHIRTY);
		LAST_18.add(NTHIRTY_ONE);
		LAST_18.add(NTHIRTY_TWO);
		LAST_18.add(NTHIRTY_THREE);
		LAST_18.add(NTHIRTY_FOUR);
		LAST_18.add(NTHIRTY_FIVE);
		LAST_18.add(NTHIRTY_SIX);

		ONE_TWO_SPLIT.add(NONE); ONE_TWO_SPLIT.add(NTWO);
		TWO_THREE_SPLIT.add(NTWO); TWO_THREE_SPLIT.add(NTHREE);
		FOUR_FIVE_SPLIT.add(NFOUR); FOUR_FIVE_SPLIT.add(NFIVE);
		FIVE_SIX_SPLIT.add(NFIVE); FIVE_SIX_SPLIT.add(NSIX);
		SEVEN_EIGHT_SPLIT.add(NSEVEN); SEVEN_EIGHT_SPLIT.add(NEIGHT);
		EIGHT_NINE_SPLIT.add(NEIGHT); EIGHT_NINE_SPLIT.add(NNINE);
		TEN_ELEVEN_SPLIT.add(NTEN); TEN_ELEVEN_SPLIT.add(NELEVEN);
		ELEVEN_TWELVE_SPLIT.add(NELEVEN); ELEVEN_TWELVE_SPLIT.add(NTWELVE);
		THIRTEEN_FOURTEEN_SPLIT.add(NTHIRTEEN); THIRTEEN_FOURTEEN_SPLIT.add(NFOURTEEN);
		FOURTEEN_FIFTEEN_SPLIT.add(NFOURTEEN); FOURTEEN_FIFTEEN_SPLIT.add(NFIFTEEN);
		SIXTEEN_SEVENTEEN_SPLIT.add(NSIXTEEN); SIXTEEN_SEVENTEEN_SPLIT.add(NSEVENTEEN);
		SEVENTEEN_EIGHTEEN_SPLIT.add(NSEVENTEEN); SEVENTEEN_EIGHTEEN_SPLIT.add(NEIGHTEEN);
		NINTEEN_TWENTY_SPLIT.add(NNINETEEN); NINTEEN_TWENTY_SPLIT.add(NTWENTY);
		TWENTY_TWENTY_ONE_SPLIT.add(NTWENTY); TWENTY_TWENTY_ONE_SPLIT.add(NTWENTY_ONE);
		TWENTY_TWO_TWENTY_THREE_SPLIT.add(NTWENTY_TWO); TWENTY_TWO_TWENTY_THREE_SPLIT.add(NTWENTY_THREE);
		TWENTY_THREE_TWENTY_FOUR_SPLIT.add(NTWENTY_THREE); TWENTY_THREE_TWENTY_FOUR_SPLIT.add(NTWENTY_FOUR);
		TWENTY_FIVE_TWENTY_SIX_SPLIT.add(NTWENTY_FIVE); TWENTY_FIVE_TWENTY_SIX_SPLIT.add(NTWENTY_SIX);
		TWENTY_SIX_TWENTY_SEVEN_SPLIT.add(NTWENTY_SIX); TWENTY_SIX_TWENTY_SEVEN_SPLIT.add(NTWENTY_SEVEN);
		TWENTY_EIGHT_TWETNY_NINE_SPLIT.add(NTWENTY_EIGHT); TWENTY_EIGHT_TWETNY_NINE_SPLIT.add(NTWENTY_NINE);
		TWENTY_NINE_THIRTY_SPLIT.add(NTWENTY_NINE); TWENTY_NINE_THIRTY_SPLIT.add(NTHIRTY);
		THIRTY_ONE_THIRTY_THRITY_TWO_SPLIT.add(NTHIRTY_ONE); THIRTY_ONE_THIRTY_THRITY_TWO_SPLIT.add(NTHIRTY_TWO);
		THRITY_TWO_THIRTY_THREE_SPLIT.add(NTHIRTY_TWO); THRITY_TWO_THIRTY_THREE_SPLIT.add(NTHIRTY_THREE);
		THRITY_FOUR_THIRTY_FIVE_SPLIT.add(NTHIRTY_FOUR); THRITY_FOUR_THIRTY_FIVE_SPLIT.add(NTHIRTY_FIVE);
		THIRTY_FIVE_THIRTY_SIX_SPLIT.add(NTHIRTY_FIVE); THIRTY_FIVE_THIRTY_SIX_SPLIT.add(NTHIRTY_SIX);
		ONE_FOUR_SPLIT.add(NONE); ONE_FOUR_SPLIT.add(NFOUR);
		TWO_FIVE_SPLIT.add(NTWO); TWO_FIVE_SPLIT.add(NFIVE);
		THREE_SIX_SPLIT.add(NTHREE); THREE_SIX_SPLIT.add(NSIX);
		FOUR_SEVEN_SPLIT.add(NFOUR); FOUR_SEVEN_SPLIT.add(NSEVEN);
		FIVE_EIGHT_SPLIT.add(NFIVE); FIVE_EIGHT_SPLIT.add(NEIGHT);
		SIX_NINE_SPLIT.add(NSIX); SIX_NINE_SPLIT.add(NNINE);
		SEVEN_TEN_SPLIT.add(NSEVEN); SEVEN_TEN_SPLIT.add(NTEN);
		EIGHT_ELEVEN_SPLIT.add(NEIGHT); EIGHT_ELEVEN_SPLIT.add(NELEVEN);
		NINE_TWELVE_SPLIT.add(NNINE); NINE_TWELVE_SPLIT.add(NTWELVE);
		TEN_THIRTEEN_SPLIT.add(NTEN); TEN_THIRTEEN_SPLIT.add(NTHIRTEEN);
		ELEVEN_FOURTEEN_SPLIT.add(NELEVEN); ELEVEN_FOURTEEN_SPLIT.add(NFOURTEEN);
		TWELVE_FIFTEEN_SPLIT.add(NTWELVE); TWELVE_FIFTEEN_SPLIT.add(NFIFTEEN);
		THIRTEEN_SIXTEEN_SPLIT.add(NTHIRTEEN); THIRTEEN_SIXTEEN_SPLIT.add(NSIXTEEN);
		FOURTEEN_SEVENTEEN_SPLIT.add(NFOURTEEN); FOURTEEN_SEVENTEEN_SPLIT.add(NSEVENTEEN);
		FIFTEEN_EIGHTEEN_SPLIT.add(NFIFTEEN); FIFTEEN_EIGHTEEN_SPLIT.add(NEIGHTEEN);
		SIXTEEN_NINETEEN_SPLIT.add(NSIXTEEN); SIXTEEN_NINETEEN_SPLIT.add(NNINETEEN);
		SEVENTEEN_TWENTY_SPLIT.add(NSEVENTEEN); SEVENTEEN_TWENTY_SPLIT.add(NTWENTY);
		EIGHTEEN_TWENTY_ONE_SPLIT.add(NEIGHTEEN); EIGHTEEN_TWENTY_ONE_SPLIT.add(NTWENTY_ONE);
		NINETEEN_TWENTY_TWO_SPLIT.add(NNINETEEN); NINETEEN_TWENTY_TWO_SPLIT.add(NTWENTY_TWO);
		TWENTY_TWENTY_THREE_SPLIT.add(NTWENTY); TWENTY_TWENTY_THREE_SPLIT.add(NTWENTY_THREE);
		TWENTY_ONE_TWENTY_FOUR_SPLIT.add(NTWENTY_ONE); TWENTY_ONE_TWENTY_FOUR_SPLIT.add(NTWENTY_FOUR);
		TWENTY_TWO_TWENTY_FIVE_SPLIT.add(NTWENTY_TWO); TWENTY_TWO_TWENTY_FIVE_SPLIT.add(NTWENTY_FIVE);
		TWENTY_THREE_TWENTY_SIX_SPLIT.add(NTWENTY_THREE); TWENTY_THREE_TWENTY_SIX_SPLIT.add(NTWENTY_SIX);
		TWENTY_FOUR_TWENTY_SEVEN_SPLIT.add(NTWENTY_FOUR); TWENTY_FOUR_TWENTY_SEVEN_SPLIT.add(NTWENTY_SEVEN);
		TWENTY_FIVE_TWENTY_EIGHT_SPLIT.add(NTWENTY_FIVE); TWENTY_FIVE_TWENTY_EIGHT_SPLIT.add(NTWENTY_EIGHT);
		TWENTY_SIX_TWENTY_NINE_SPLIT.add(NTWENTY_SIX); TWENTY_SIX_TWENTY_NINE_SPLIT.add(NTWENTY_NINE);
		TWENTY_SEVEN_THIRTY_SPLIT.add(NTWENTY_SEVEN); TWENTY_SEVEN_THIRTY_SPLIT.add(NTHIRTY);
		TWENTY_EIGHT_THIRTY_ONE_SPLIT.add(NTWENTY_EIGHT); TWENTY_EIGHT_THIRTY_ONE_SPLIT.add(NTHIRTY_ONE);
		TWENTY_NINE_THRITY_TWO_SPLIT.add(NTWENTY_NINE); TWENTY_NINE_THRITY_TWO_SPLIT.add(NTHIRTY_TWO);
		THIRTY_THIRTY_THREE_SPLIT.add(NTHIRTY); THIRTY_THIRTY_THREE_SPLIT.add(NTHIRTY_THREE);
		THIRTY_ONE_THIRTY_FOUR_SPLIT.add(NTHIRTY_ONE); THIRTY_ONE_THIRTY_FOUR_SPLIT.add(NTHIRTY_FOUR);
		THIRTY_TWO_THIRTY_FIVE_SPLIT.add(NTHIRTY_TWO); THIRTY_TWO_THIRTY_FIVE_SPLIT.add(NTHIRTY_FIVE);
		THIRTY_THREE_THIRTY_SIX_SPLIT.add(NTHIRTY_THREE); THIRTY_THREE_THIRTY_SIX_SPLIT.add(NTHIRTY_SIX);

		ONE_TWO_THREE_STREET.add(NONE); ONE_TWO_THREE_STREET.add(NTWO); ONE_TWO_THREE_STREET.add(NTHREE);
		FOUR_FIVE_SIX_STREET.add(NFOUR); FOUR_FIVE_SIX_STREET.add(NFIVE); FOUR_FIVE_SIX_STREET.add(NSIX);
		SEVEN_EIGHT_NINE_STREET.add(NSEVEN); SEVEN_EIGHT_NINE_STREET.add(NEIGHT); SEVEN_EIGHT_NINE_STREET.add(NNINE);
		TEN_ELEVEN_TWELVE_STREET.add(NTEN); TEN_ELEVEN_TWELVE_STREET.add(NELEVEN); TEN_ELEVEN_TWELVE_STREET.add(NTWELVE);
		THIRTEEN_FOURTEEN_FIFTEEN_STREET.add(NTHIRTEEN); THIRTEEN_FOURTEEN_FIFTEEN_STREET.add(NFOURTEEN); THIRTEEN_FOURTEEN_FIFTEEN_STREET.add(NFIFTEEN);
		SIXTEEN_SEVENTEEN_EIGHTEEN_STREET.add(NSIXTEEN); SIXTEEN_SEVENTEEN_EIGHTEEN_STREET.add(NSEVENTEEN); SIXTEEN_SEVENTEEN_EIGHTEEN_STREET.add(NEIGHTEEN);
		NINETEEN_TWENTY_TWENTY_ONE_STREET.add(NNINETEEN); NINETEEN_TWENTY_TWENTY_ONE_STREET.add(NTWENTY); NINETEEN_TWENTY_TWENTY_ONE_STREET.add(NTWENTY_ONE);
		TWENTY_TWO_TWENTY_THREE_TWENTY_FOUR_STREET.add(NTWENTY_TWO); TWENTY_TWO_TWENTY_THREE_TWENTY_FOUR_STREET.add(NTWENTY_THREE); TWENTY_TWO_TWENTY_THREE_TWENTY_FOUR_STREET.add(NTWENTY_FOUR);
		TWENTY_FIVE_TWENTY_SIX_TWENTY_SEVEN_STREET.add(NTWENTY_FIVE); TWENTY_FIVE_TWENTY_SIX_TWENTY_SEVEN_STREET.add(NTWENTY_SIX); TWENTY_FIVE_TWENTY_SIX_TWENTY_SEVEN_STREET.add(NTWENTY_SEVEN);
		TWENTY_EIGHT_TWENTY_NINE_THIRTY_STREET.add(NTWENTY_EIGHT); TWENTY_EIGHT_TWENTY_NINE_THIRTY_STREET.add(NTWENTY_NINE); TWENTY_EIGHT_TWENTY_NINE_THIRTY_STREET.add(NTHIRTY);
		THIRTY_ONE_THIRTY_TWO_THIRTY_THREE_STREET.add(NTHIRTY_ONE); THIRTY_ONE_THIRTY_TWO_THIRTY_THREE_STREET.add(NTHIRTY_TWO); THIRTY_ONE_THIRTY_TWO_THIRTY_THREE_STREET.add(NTHIRTY_THREE);
		THIRTY_FOUR_THRITY_FIVE_THIRTY_SIX_STREET.add(NTHIRTY_FOUR); THIRTY_FOUR_THRITY_FIVE_THIRTY_SIX_STREET.add(NTHIRTY_FIVE); THIRTY_FOUR_THRITY_FIVE_THIRTY_SIX_STREET.add(NTHIRTY_SIX);
		
		ONE_2_4_5_CORNER.add(NONE); ONE_2_4_5_CORNER.add(NTWO); ONE_2_4_5_CORNER.add(NFOUR); ONE_2_4_5_CORNER.add(NFIVE);
		TWO_3_5_6_CORNER.add(NTWO); TWO_3_5_6_CORNER.add(NTHREE); TWO_3_5_6_CORNER.add(NFIVE); TWO_3_5_6_CORNER.add(NSIX); 
		FOUR_5_7_8_CORNER.add(NFOUR); FOUR_5_7_8_CORNER.add(NFIVE); FOUR_5_7_8_CORNER.add(NSEVEN); FOUR_5_7_8_CORNER.add(NEIGHT); 
		FIVE_6_8_9_CORNER.add(NFIVE); FIVE_6_8_9_CORNER.add(NSIX); FIVE_6_8_9_CORNER.add(NEIGHT); FIVE_6_8_9_CORNER.add(NNINE); 
		SEVEN_8_10_11_CORNER.add(NSEVEN); SEVEN_8_10_11_CORNER.add(NEIGHT); SEVEN_8_10_11_CORNER.add(NTEN); SEVEN_8_10_11_CORNER.add(NELEVEN); 
		EIGHT_9_11_12_CORNER.add(NEIGHT); EIGHT_9_11_12_CORNER.add(NNINE); EIGHT_9_11_12_CORNER.add(NELEVEN); EIGHT_9_11_12_CORNER.add(NTWELVE); 
		TEN_11_13_14_CORNER.add(NTEN); TEN_11_13_14_CORNER.add(NELEVEN); TEN_11_13_14_CORNER.add(NTHIRTEEN); TEN_11_13_14_CORNER.add(NFOURTEEN); 
		ELEVEN_12_14_15_CORNER.add(NELEVEN); ELEVEN_12_14_15_CORNER.add(NTWELVE); ELEVEN_12_14_15_CORNER.add(NFOURTEEN); ELEVEN_12_14_15_CORNER.add(NFIFTEEN); 
		THIRTEEN_14_16_17_CORNER.add(NTHIRTEEN); THIRTEEN_14_16_17_CORNER.add(NFOURTEEN); THIRTEEN_14_16_17_CORNER.add(NSIXTEEN); THIRTEEN_14_16_17_CORNER.add(NSEVENTEEN); 
		FOURTEEN_15_17_18_CORNER.add(NFOURTEEN); FOURTEEN_15_17_18_CORNER.add(NFIFTEEN); FOURTEEN_15_17_18_CORNER.add(NSEVENTEEN); FOURTEEN_15_17_18_CORNER.add(NEIGHTEEN); 
		SIXTEEN_17_19_20_CORNER.add(NSIXTEEN); SIXTEEN_17_19_20_CORNER.add(NSEVENTEEN); SIXTEEN_17_19_20_CORNER.add(NNINETEEN); SIXTEEN_17_19_20_CORNER.add(NTWENTY); 
		SEVENTEEN_18_20_21_CORNER.add(NSEVENTEEN); SEVENTEEN_18_20_21_CORNER.add(NEIGHTEEN); SEVENTEEN_18_20_21_CORNER.add(NTWENTY); SEVENTEEN_18_20_21_CORNER.add(NTWENTY_ONE); 
		NINETEEN_20_22_23_CORNER.add(NNINETEEN); NINETEEN_20_22_23_CORNER.add(NTWENTY); NINETEEN_20_22_23_CORNER.add(NTWENTY_TWO); NINETEEN_20_22_23_CORNER.add(NTWENTY_THREE); 
		TWENTY_21_23_24_CORNER.add(NTWENTY); TWENTY_21_23_24_CORNER.add(NTWENTY_ONE); TWENTY_21_23_24_CORNER.add(NTWENTY_THREE); TWENTY_21_23_24_CORNER.add(NTWENTY_FOUR); 
		TWENTY_TWO_23_25_26_CORNER.add(NTWENTY_TWO); TWENTY_TWO_23_25_26_CORNER.add(NTWENTY_THREE); TWENTY_TWO_23_25_26_CORNER.add(NTWENTY_FIVE); TWENTY_TWO_23_25_26_CORNER.add(NTWENTY_SIX); 
		TWENTY_THREE_24_26_27_CORNER.add(NTWENTY_THREE); TWENTY_THREE_24_26_27_CORNER.add(NTWENTY_FOUR); TWENTY_THREE_24_26_27_CORNER.add(NTWENTY_SIX); TWENTY_THREE_24_26_27_CORNER.add(NTWENTY_SEVEN); 
		TWENTY_FIVE_26_28_29_CORNER.add(NTWENTY_FIVE); TWENTY_FIVE_26_28_29_CORNER.add(NTWENTY_SIX); TWENTY_FIVE_26_28_29_CORNER.add(NTWENTY_EIGHT); TWENTY_FIVE_26_28_29_CORNER.add(NTWENTY_NINE); 
		TWENTY_SIX_27_29_30_CORNER.add(NTWENTY_SIX); TWENTY_SIX_27_29_30_CORNER.add(NTWENTY_SEVEN); TWENTY_SIX_27_29_30_CORNER.add(NTWENTY_NINE); TWENTY_SIX_27_29_30_CORNER.add(NTHIRTY); 
		TWENT_EIGHT_29_31_32_CORNER.add(NTWENTY_EIGHT); TWENT_EIGHT_29_31_32_CORNER.add(NTWENTY_NINE); TWENT_EIGHT_29_31_32_CORNER.add(NTHIRTY_ONE); TWENT_EIGHT_29_31_32_CORNER.add(NTHIRTY_TWO); 
		TWENTY_NINE_30_32_33_CORNER.add(NTWENTY_NINE); TWENTY_NINE_30_32_33_CORNER.add(NTHIRTY); TWENTY_NINE_30_32_33_CORNER.add(NTHIRTY_TWO); TWENTY_NINE_30_32_33_CORNER.add(NTHIRTY_THREE); 
		THIRTY_ONE_32_34_35_CORNER.add(NTHIRTY_ONE); THIRTY_ONE_32_34_35_CORNER.add(NTHIRTY_TWO); THIRTY_ONE_32_34_35_CORNER.add(NTHIRTY_FOUR); THIRTY_ONE_32_34_35_CORNER.add(NTHIRTY_FIVE); 
		THIRTY_TWO_33_35_36_CORNER.add(NTHIRTY_TWO); THIRTY_TWO_33_35_36_CORNER.add(NTHIRTY_THREE); THIRTY_TWO_33_35_36_CORNER.add(NTHIRTY_FIVE); THIRTY_TWO_33_35_36_CORNER.add(NTHIRTY_SIX); 

		ONE_4_SIXLINE.add(NONE); ONE_4_SIXLINE.add(NFOUR);
		ONE_4_SIXLINE.add(NTWO); ONE_4_SIXLINE.add(NFIVE);
		ONE_4_SIXLINE.add(NTHREE); ONE_4_SIXLINE.add(NSIX);
		FOUR_7_SIXLINE.add(NFOUR); FOUR_7_SIXLINE.add(NSEVEN);
		FOUR_7_SIXLINE.add(NFIVE); FOUR_7_SIXLINE.add(NEIGHT);
		FOUR_7_SIXLINE.add(NSIX); FOUR_7_SIXLINE.add(NNINE);
		SEVEN_10_SIXLINE.add(NSEVEN); SEVEN_10_SIXLINE.add(NTEN);
		SEVEN_10_SIXLINE.add(NEIGHT); SEVEN_10_SIXLINE.add(NELEVEN);
		SEVEN_10_SIXLINE.add(NNINE); SEVEN_10_SIXLINE.add(NTWELVE);
		TEN_13_SIXLINE.add(NTEN); TEN_13_SIXLINE.add(NTHIRTEEN);
		TEN_13_SIXLINE.add(NELEVEN); TEN_13_SIXLINE.add(NFOURTEEN);
		TEN_13_SIXLINE.add(NTWELVE); TEN_13_SIXLINE.add(NFIFTEEN);
		THIRTEEN_16_SIXLINE.add(NTHIRTEEN); THIRTEEN_16_SIXLINE.add(NSIXTEEN);
		THIRTEEN_16_SIXLINE.add(NFOURTEEN); THIRTEEN_16_SIXLINE.add(NSEVENTEEN);
		THIRTEEN_16_SIXLINE.add(NFIFTEEN); THIRTEEN_16_SIXLINE.add(NEIGHTEEN);
		SIXTEEN_19_SIXLINE.add(NSIXTEEN); SIXTEEN_19_SIXLINE.add(NNINETEEN);
		SIXTEEN_19_SIXLINE.add(NSEVENTEEN); SIXTEEN_19_SIXLINE.add(NTWENTY);
		SIXTEEN_19_SIXLINE.add(NEIGHTEEN); SIXTEEN_19_SIXLINE.add(NTWENTY_ONE);
		NINETEEN_22_SIXLINE.add(NNINETEEN); NINETEEN_22_SIXLINE.add(NTWENTY_TWO);
		NINETEEN_22_SIXLINE.add(NTWENTY); NINETEEN_22_SIXLINE.add(NTWENTY_THREE);
		NINETEEN_22_SIXLINE.add(NTWENTY_ONE); NINETEEN_22_SIXLINE.add(NTWENTY_FOUR);
		TWENTY_TWO_25_SIXLINE.add(NTWENTY_TWO); TWENTY_TWO_25_SIXLINE.add(NTWENTY_FIVE);
		TWENTY_TWO_25_SIXLINE.add(NTWENTY_THREE); TWENTY_TWO_25_SIXLINE.add(NTWENTY_SIX);
		TWENTY_TWO_25_SIXLINE.add(NTWENTY_FOUR); TWENTY_TWO_25_SIXLINE.add(NTWENTY_SEVEN);
		TWENTY_FIVE_28_SIXLINE.add(NTWENTY_FIVE); TWENTY_FIVE_28_SIXLINE.add(NTWENTY_EIGHT);
		TWENTY_FIVE_28_SIXLINE.add(NTWENTY_SIX); TWENTY_FIVE_28_SIXLINE.add(NTWENTY_NINE);
		TWENTY_FIVE_28_SIXLINE.add(NTWENTY_SEVEN); TWENTY_FIVE_28_SIXLINE.add(NTHIRTY);
		TWENTY_EIGHT_31_SIXLINE.add(NTWENTY_EIGHT); TWENTY_EIGHT_31_SIXLINE.add(NTHIRTY_ONE);
		TWENTY_EIGHT_31_SIXLINE.add(NTWENTY_NINE); TWENTY_EIGHT_31_SIXLINE.add(NTHIRTY_TWO);
		TWENTY_EIGHT_31_SIXLINE.add(NTHIRTY); TWENTY_EIGHT_31_SIXLINE.add(NTHIRTY_THREE);
		THIRTY_ONE_34_SIXLINE.add(NTHIRTY_ONE); THIRTY_ONE_34_SIXLINE.add(NTHIRTY_FOUR);
		THIRTY_ONE_34_SIXLINE.add(NTHIRTY_TWO); THIRTY_ONE_34_SIXLINE.add(NTHIRTY_FIVE);
		THIRTY_ONE_34_SIXLINE.add(NTHIRTY_THREE); THIRTY_ONE_34_SIXLINE.add(NTHIRTY_SIX); 

		ZERO_1_2_TRIO.add(NZERO); ZERO_1_2_TRIO.add(NONE); ZERO_1_2_TRIO.add(NTWO); 
		ZERO_2_3_TRIO.add(NZERO); ZERO_2_3_TRIO.add(NTWO); ZERO_2_3_TRIO.add(NTHREE); 
		ZERO_1_2_BASKET.add(NZERO); ZERO_1_2_BASKET.add(NONE); ZERO_1_2_BASKET.add(NTWO);  

		TOPLINE.add(NZERO);
		TOPLINE.add(NONE);
		TOPLINE.add(NTWO);
		TOPLINE.add(NTHREE);

	}
	
	public String[] getBetChoices(){
		EuropeanTypeOfBet[] values = EuropeanTypeOfBet.values();
		String[] stringValues = new String[values.length];
		
		for(int i = 0; i < values.length; i++){
			stringValues[i] = values[i].name() + ", ";
		}
		
		stringValues[values.length - 1] = stringValues[values.length - 1].replace(", ", ""); 
		
		return stringValues;
	}

	private Set<Integer> bet;
	
	private int amount;
	
	private String betName;
	
	public void setBetName(String betName){
		this.betName = betName;
	}
	
	public String getBetName(){
		return betName;
	}

	public void setBet(Set<Integer> bet){
		this.bet = bet;
	}
	
	public Set<Integer> getBet(){
		return this.bet;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public EuropeanBet(){
		super();
	}
	
	public EuropeanBet(final String betName, final Money amount){
		this();
		this.bet = determineBet(betName.toUpperCase());
		this.amount = amount.getAmount();
		this.betName = betName.toUpperCase();
	}
	
	private Set<Integer> determineBet(final String betName){
		Set<Integer> theBet = null;
		EuropeanTypeOfBet betEnum = EuropeanTypeOfBet.valueOf(betName);
		switch(betEnum){
			case BLACK: theBet = BLACK; break;
			case RED: theBet = RED; break;
			case ODDS: theBet = ODDS; break;
			case EVENS: theBet = EVENS; break;
			case ZERO: theBet = ZERO; break;
			case FIRST_18: theBet = FIRST_18; break;
			case LAST_18: theBet = LAST_18; break;
			case FIRST_DOZEN: theBet = FIRST_DOZEN; break;
			case SECOND_DOZEN: theBet = SECOND_DOZEN; break;
			case THIRD_DOZEN: theBet = THIRD_DOZEN; break;
			case FIRST_COLUMN: theBet = FIRST_COLUMN; break;
			case SECOND_COLUMN: theBet = SECOND_COLUMN; break;
			case THIRD_COLUMN: theBet = THIRD_COLUMN; break;
			case ONE: theBet = ONE; break;
			case TWO: theBet = TWO; break;
			case THREE: theBet = THREE; break;
			case FOUR: theBet = FOUR; break;
			case FIVE: theBet = FIVE; break;
			case SIX: theBet = SIX; break;
			case SEVEN: theBet = SEVEN; break;
			case EIGHT: theBet = EIGHT; break;
			case NINE: theBet = NINE; break;
			case TEN: theBet = TEN; break;
			case ELEVEN: theBet = ELEVEN; break;
			case TWELVE: theBet = TWELVE; break;
			case THIRTEEN: theBet = THIRTEEN; break;
			case FOURTEEN: theBet = FOURTEEN; break;
			case FIFTEEN: theBet = FIFTEEN; break;
			case SIXTEEN: theBet = SIXTEEN; break;
			case SEVENTEEN: theBet = SEVENTEEN; break;
			case EIGHTEEN: theBet = EIGHTEEN; break;
			case NINETEEN: theBet = NINETEEN; break;
			case TWENTY: theBet = TWENTY; break;
			case TWENTY_ONE: theBet = TWENTY_ONE; break;
			case TWENTY_TWO: theBet = TWENTY_TWO; break;
			case TWENTY_THREE: theBet = TWENTY_THREE; break;
			case TWENTY_FOUR: theBet = TWENTY_FOUR; break;
			case TWENTY_FIVE: theBet = TWENTY_FIVE; break;
			case TWENTY_SIX: theBet = TWENTY_SIX; break;
			case TWENTY_SEVEN: theBet = TWENTY_SEVEN; break;
			case TWENTY_EIGHT: theBet = TWENTY_EIGHT; break;
			case TWENTY_NINE: theBet = TWENTY_NINE; break;
			case THIRTY: theBet = THIRTY; break;
			case THRITY_ONE: theBet = THRITY_ONE; break;
			case THRITY_TWO: theBet = THRITY_TWO; break;
			case THRITY_THREE: theBet = THRITY_THREE; break;
			case THRITY_FOUR: theBet = THRITY_FOUR; break;
			case THRITY_FIVE: theBet = THRITY_FIVE; break;
			case THRITY_SIX: theBet = THRITY_SIX; break;
			case ONE_TWO_SPLIT: theBet = ONE_TWO_SPLIT; break;
			case TWO_THREE_SPLIT: theBet = TWO_THREE_SPLIT; break;
			case FOUR_FIVE_SPLIT: theBet = FOUR_FIVE_SPLIT; break;
			case FIVE_SIX_SPLIT: theBet = FIVE_SIX_SPLIT; break;
			case SEVEN_EIGHT_SPLIT: theBet = SEVEN_EIGHT_SPLIT; break;
			case EIGHT_NINE_SPLIT: theBet = EIGHT_NINE_SPLIT; break;
			case TEN_ELEVEN_SPLIT: theBet = TEN_ELEVEN_SPLIT; break;
			case ELEVEN_TWELVE_SPLIT: theBet = ELEVEN_TWELVE_SPLIT; break;
			case THIRTEEN_FOURTEEN_SPLIT: theBet = THIRTEEN_FOURTEEN_SPLIT; break;
			case FOURTEEN_FIFTEEN_SPLIT: theBet = FOURTEEN_FIFTEEN_SPLIT; break;
			case SIXTEEN_SEVENTEEN_SPLIT: theBet = SIXTEEN_SEVENTEEN_SPLIT; break;
			case SEVENTEEN_EIGHTEEN_SPLIT: theBet = SEVENTEEN_EIGHTEEN_SPLIT; break;
			case NINTEEN_TWENTY_SPLIT: theBet = NINTEEN_TWENTY_SPLIT; break;
			case TWENTY_TWENTY_ONE_SPLIT: theBet = TWENTY_TWENTY_ONE_SPLIT; break;
			case TWENTY_TWO_TWENTY_THREE_SPLIT: theBet = TWENTY_TWO_TWENTY_THREE_SPLIT; break;
			case TWENTY_THREE_TWENTY_FOUR_SPLIT: theBet = TWENTY_THREE_TWENTY_FOUR_SPLIT; break;
			case TWENTY_FIVE_TWENTY_SIX_SPLIT: theBet = TWENTY_FIVE_TWENTY_SIX_SPLIT; break;
			case TWENTY_SIX_TWENTY_SEVEN_SPLIT: theBet = TWENTY_SIX_TWENTY_SEVEN_SPLIT; break;
			case TWENTY_EIGHT_TWETNY_NINE_SPLIT: theBet = TWENTY_EIGHT_TWETNY_NINE_SPLIT; break;
			case TWENTY_NINE_THIRTY_SPLIT: theBet = TWENTY_NINE_THIRTY_SPLIT; break;
			case THIRTY_ONE_THIRTY_THRITY_TWO_SPLIT: theBet = THIRTY_ONE_THIRTY_THRITY_TWO_SPLIT; break;
			case THRITY_TWO_THIRTY_THREE_SPLIT: theBet = THRITY_TWO_THIRTY_THREE_SPLIT; break;
			case THRITY_FOUR_THIRTY_FIVE_SPLIT: theBet = THRITY_FOUR_THIRTY_FIVE_SPLIT; break;
			case THIRTY_FIVE_THIRTY_SIX_SPLIT: theBet = THIRTY_FIVE_THIRTY_SIX_SPLIT; break;
			case ONE_FOUR_SPLIT: theBet = ONE_FOUR_SPLIT; break;
			case TWO_FIVE_SPLIT: theBet = TWO_FIVE_SPLIT; break;
			case THREE_SIX_SPLIT: theBet = THREE_SIX_SPLIT; break;
			case FOUR_SEVEN_SPLIT: theBet = FOUR_SEVEN_SPLIT; break;
			case FIVE_EIGHT_SPLIT: theBet = FIVE_EIGHT_SPLIT; break;
			case SIX_NINE_SPLIT: theBet = SIX_NINE_SPLIT; break;
			case SEVEN_TEN_SPLIT: theBet = SEVEN_TEN_SPLIT; break;
			case EIGHT_ELEVEN_SPLIT: theBet = EIGHT_ELEVEN_SPLIT; break;
			case NINE_TWELVE_SPLIT: theBet = NINE_TWELVE_SPLIT; break;
			case TEN_THIRTEEN_SPLIT: theBet = TEN_THIRTEEN_SPLIT; break;
			case ELEVEN_FOURTEEN_SPLIT: theBet = ELEVEN_FOURTEEN_SPLIT; break;
			case TWELVE_FIFTEEN_SPLIT: theBet = TWELVE_FIFTEEN_SPLIT; break;
			case THIRTEEN_SIXTEEN_SPLIT: theBet = THIRTEEN_SIXTEEN_SPLIT; break;
			case FOURTEEN_SEVENTEEN_SPLIT: theBet = FOURTEEN_SEVENTEEN_SPLIT; break;
			case FIFTEEN_EIGHTEEN_SPLIT: theBet = FIFTEEN_EIGHTEEN_SPLIT; break;
			case SIXTEEN_NINETEEN_SPLIT: theBet = SIXTEEN_NINETEEN_SPLIT; break;
			case SEVENTEEN_TWENTY_SPLIT: theBet = SEVENTEEN_TWENTY_SPLIT; break;
			case EIGHTEEN_TWENTY_ONE_SPLIT: theBet = EIGHTEEN_TWENTY_ONE_SPLIT; break;
			case NINETEEN_TWENTY_TWO_SPLIT: theBet = NINETEEN_TWENTY_TWO_SPLIT; break;
			case TWENTY_TWENTY_THREE_SPLIT: theBet = TWENTY_TWENTY_THREE_SPLIT; break;
			case TWENTY_ONE_TWENTY_FOUR_SPLIT: theBet = TWENTY_ONE_TWENTY_FOUR_SPLIT; break;
			case TWENTY_TWO_TWENTY_FIVE_SPLIT: theBet = TWENTY_TWO_TWENTY_FIVE_SPLIT; break;
			case TWENTY_THREE_TWENTY_SIX_SPLIT: theBet = TWENTY_THREE_TWENTY_SIX_SPLIT; break;
			case TWENTY_FOUR_TWENTY_SEVEN_SPLIT: theBet = TWENTY_FOUR_TWENTY_SEVEN_SPLIT; break;
			case TWENTY_FIVE_TWENTY_EIGHT_SPLIT: theBet = TWENTY_FIVE_TWENTY_EIGHT_SPLIT; break;
			case TWENTY_SIX_TWENTY_NINE_SPLIT: theBet = TWENTY_SIX_TWENTY_NINE_SPLIT; break;
			case TWENTY_SEVEN_THIRTY_SPLIT: theBet = TWENTY_SEVEN_THIRTY_SPLIT; break;
			case TWENTY_EIGHT_THIRTY_ONE_SPLIT: theBet = TWENTY_EIGHT_THIRTY_ONE_SPLIT; break;
			case TWENTY_NINE_THRITY_TWO_SPLIT: theBet = TWENTY_NINE_THRITY_TWO_SPLIT; break;
			case THIRTY_THIRTY_THREE_SPLIT: theBet = THIRTY_THIRTY_THREE_SPLIT; break;
			case THIRTY_ONE_THIRTY_FOUR_SPLIT: theBet = THIRTY_ONE_THIRTY_FOUR_SPLIT; break;
			case THIRTY_TWO_THIRTY_FIVE_SPLIT: theBet = THIRTY_TWO_THIRTY_FIVE_SPLIT; break;
			case THIRTY_THREE_THIRTY_SIX_SPLIT: theBet = THIRTY_THREE_THIRTY_SIX_SPLIT; break;
			case ONE_TWO_THREE_STREET: theBet = ONE_TWO_THREE_STREET; break;
			case FOUR_FIVE_SIX_STREET: theBet = FOUR_FIVE_SIX_STREET; break;
			case SEVEN_EIGHT_NINE_STREET: theBet = SEVEN_EIGHT_NINE_STREET; break;
			case TEN_ELEVEN_TWELVE_STREET: theBet = TEN_ELEVEN_TWELVE_STREET; break;
			case THIRTEEN_FOURTEEN_FIFTEEN_STREET: theBet = THIRTEEN_FOURTEEN_FIFTEEN_STREET; break;
			case SIXTEEN_SEVENTEEN_EIGHTEEN_STREET: theBet = SIXTEEN_SEVENTEEN_EIGHTEEN_STREET; break;
			case NINETEEN_TWENTY_TWENTY_ONE_STREET: theBet = NINETEEN_TWENTY_TWENTY_ONE_STREET; break;
			case TWENTY_TWO_TWENTY_THREE_TWENTY_FOUR_STREET: theBet = TWENTY_TWO_TWENTY_THREE_TWENTY_FOUR_STREET; break;
			case TWENTY_FIVE_TWENTY_SIX_TWENTY_SEVEN_STREET: theBet = TWENTY_FIVE_TWENTY_SIX_TWENTY_SEVEN_STREET; break;
			case TWENTY_EIGHT_TWENTY_NINE_THIRTY_STREET: theBet = TWENTY_EIGHT_TWENTY_NINE_THIRTY_STREET; break;
			case THIRTY_ONE_THIRTY_TWO_THIRTY_THREE_STREET: theBet = THIRTY_ONE_THIRTY_TWO_THIRTY_THREE_STREET; break;
			case THIRTY_FOUR_THRITY_FIVE_THIRTY_SIX_STREET: theBet = THIRTY_FOUR_THRITY_FIVE_THIRTY_SIX_STREET; break;
			case ONE_2_4_5_CORNER: theBet = ONE_2_4_5_CORNER; break;
			case TWO_3_5_6_CORNER: theBet = TWO_3_5_6_CORNER; break;
			case FOUR_5_7_8_CORNER: theBet = FOUR_5_7_8_CORNER; break;
			case FIVE_6_8_9_CORNER: theBet = FIVE_6_8_9_CORNER; break;
			case SEVEN_8_10_11_CORNER: theBet = SEVEN_8_10_11_CORNER; break;
			case EIGHT_9_11_12_CORNER: theBet = EIGHT_9_11_12_CORNER; break;
			case TEN_11_13_14_CORNER: theBet = TEN_11_13_14_CORNER; break;
			case ELEVEN_12_14_15_CORNER: theBet = ELEVEN_12_14_15_CORNER; break;
			case THIRTEEN_14_16_17_CORNER: theBet = THIRTEEN_14_16_17_CORNER; break;
			case FOURTEEN_15_17_18_CORNER: theBet = FOURTEEN_15_17_18_CORNER; break;
			case SIXTEEN_17_19_20_CORNER: theBet = SIXTEEN_17_19_20_CORNER; break;
			case SEVENTEEN_18_20_21_CORNER: theBet = SEVENTEEN_18_20_21_CORNER; break;
			case NINETEEN_20_22_23_CORNER: theBet = NINETEEN_20_22_23_CORNER; break;
			case TWENTY_21_23_24_CORNER: theBet = TWENTY_21_23_24_CORNER; break;
			case TWENTY_TWO_23_25_26_CORNER: theBet = TWENTY_TWO_23_25_26_CORNER; break;
			case TWENTY_THREE_24_26_27_CORNER: theBet = TWENTY_THREE_24_26_27_CORNER; break;
			case TWENTY_FIVE_26_28_29_CORNER: theBet = TWENTY_FIVE_26_28_29_CORNER; break;
			case TWENTY_SIX_27_29_30_CORNER: theBet = TWENTY_SIX_27_29_30_CORNER; break;
			case TWENT_EIGHT_29_31_32_CORNER: theBet = TWENT_EIGHT_29_31_32_CORNER; break;
			case TWENTY_NINE_30_32_33_CORNER: theBet = TWENTY_NINE_30_32_33_CORNER; break;
			case THIRTY_ONE_32_34_35_CORNER: theBet = THIRTY_ONE_32_34_35_CORNER; break;
			case THIRTY_TWO_33_35_36_CORNER: theBet = THIRTY_TWO_33_35_36_CORNER; break;
			case ONE_4_SIXLINE: theBet = ONE_4_SIXLINE; break;
			case FOUR_7_SIXLINE: theBet = FOUR_7_SIXLINE; break;
			case SEVEN_10_SIXLINE: theBet = SEVEN_10_SIXLINE; break;
			case TEN_13_SIXLINE: theBet = TEN_13_SIXLINE; break;
			case THIRTEEN_16_SIXLINE: theBet = THIRTEEN_16_SIXLINE; break;
			case SIXTEEN_19_SIXLINE: theBet = SIXTEEN_19_SIXLINE; break;
			case NINETEEN_22_SIXLINE: theBet = NINETEEN_22_SIXLINE; break;
			case TWENTY_TWO_25_SIXLINE: theBet = TWENTY_TWO_25_SIXLINE; break;
			case TWENTY_FIVE_28_SIXLINE: theBet = TWENTY_FIVE_28_SIXLINE; break;
			case TWENTY_EIGHT_31_SIXLINE: theBet = TWENTY_EIGHT_31_SIXLINE; break;
			case THIRTY_ONE_34_SIXLINE: theBet = THIRTY_ONE_34_SIXLINE; break;
			case ZERO_1_2_TRIO: theBet = ZERO_1_2_TRIO; break;
			case ZERO_2_3_TRIO: theBet = ZERO_2_3_TRIO; break;
			default: theBet = null;
		}
		
		return theBet;
	}

	public String[] getArrayOfBets(){
		return stringArrayOfBets;
	}
	
	private static final String[] stringArrayOfBets;
	
	static{
		EuropeanTypeOfBet[] localArray = EuropeanTypeOfBet.values();
		stringArrayOfBets = new String[EuropeanTypeOfBet.values().length];
		int i = 0;
		for(; i < stringArrayOfBets.length; i++){
			stringArrayOfBets[i] = localArray[i].name() + ARRAY_DELIMITER;
		}
		stringArrayOfBets[i - 1] = localArray[i - 1].name();
	}
	
	@Override
	public boolean isValidBet(String betName) {
		return super.isValidBet(betName, stringArrayOfBets);
	}

}