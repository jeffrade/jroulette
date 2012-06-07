package com.rade.jeff.main.data;

import java.util.HashMap;
import java.util.Map;

public class Ratio {

	private static final Map<String, Integer> payoutRatioMap = new HashMap<String, Integer>();
	
	private static final Integer ONE = Integer.valueOf(1);
	
	private static final Integer TWO = Integer.valueOf(2);
	
	private static final Integer FIVE = Integer.valueOf(5);
	
	private static final Integer SIX = Integer.valueOf(6);
	
	private static final Integer EIGHT = Integer.valueOf(8);
	
	private static final Integer ELEVEN = Integer.valueOf(11);
	
	private static final Integer SEVENTEEN = Integer.valueOf(17);
	
	private static final Integer THIRTY_FIVE = Integer.valueOf(35);
	
	static{
		payoutRatioMap.put("BLACK", ONE);
		payoutRatioMap.put("RED", ONE);
		payoutRatioMap.put("GREEN", SEVENTEEN);
		payoutRatioMap.put("ODDS", ONE);
		payoutRatioMap.put("EVENS", ONE);
		payoutRatioMap.put("ZERO", THIRTY_FIVE);
		payoutRatioMap.put("DOUBLE_ZERO", THIRTY_FIVE);
		payoutRatioMap.put("BOTH_ZEROS", SEVENTEEN);
		payoutRatioMap.put("FIRST_18", ONE);
		payoutRatioMap.put("LAST_18", ONE);
		payoutRatioMap.put("FIRST_DOZEN", TWO);
		payoutRatioMap.put("SECOND_DOZEN", TWO);
		payoutRatioMap.put("THIRD_DOZEN", TWO);
		payoutRatioMap.put("FIRST_COLUMN", TWO);
		payoutRatioMap.put("SECOND_COLUMN", TWO);
		payoutRatioMap.put("THIRD_COLUMN", TWO);
		payoutRatioMap.put("ONE", THIRTY_FIVE);
		payoutRatioMap.put("TWO", THIRTY_FIVE);
		payoutRatioMap.put("THREE", THIRTY_FIVE);
		payoutRatioMap.put("FOUR", THIRTY_FIVE);
		payoutRatioMap.put("FIVE", THIRTY_FIVE);
		payoutRatioMap.put("SIX", THIRTY_FIVE);
		payoutRatioMap.put("SEVEN", THIRTY_FIVE);
		payoutRatioMap.put("EIGHT", THIRTY_FIVE);
		payoutRatioMap.put("NINE", THIRTY_FIVE);
		payoutRatioMap.put("TEN", THIRTY_FIVE);
		payoutRatioMap.put("ELEVEN", THIRTY_FIVE);
		payoutRatioMap.put("TWELVE", THIRTY_FIVE);
		payoutRatioMap.put("THIRTEEN", THIRTY_FIVE);
		payoutRatioMap.put("FOURTEEN", THIRTY_FIVE);
		payoutRatioMap.put("FIFTEEN", THIRTY_FIVE);
		payoutRatioMap.put("SIXTEEN", THIRTY_FIVE);
		payoutRatioMap.put("SEVENTEEN", THIRTY_FIVE);
		payoutRatioMap.put("EIGHTEEN", THIRTY_FIVE);
		payoutRatioMap.put("NINETEEN", THIRTY_FIVE);
		payoutRatioMap.put("TWENTY", THIRTY_FIVE);
		payoutRatioMap.put("TWENTY_ONE", THIRTY_FIVE);
		payoutRatioMap.put("TWENTY_TWO", THIRTY_FIVE);
		payoutRatioMap.put("TWENTY_THREE", THIRTY_FIVE);
		payoutRatioMap.put("TWENTY_FOUR", THIRTY_FIVE);
		payoutRatioMap.put("TWENTY_FIVE", THIRTY_FIVE);
		payoutRatioMap.put("TWENTY_SIX", THIRTY_FIVE);
		payoutRatioMap.put("TWENTY_SEVEN", THIRTY_FIVE);
		payoutRatioMap.put("TWENTY_EIGHT", THIRTY_FIVE);
		payoutRatioMap.put("TWENTY_NINE", THIRTY_FIVE);
		payoutRatioMap.put("THIRTY", THIRTY_FIVE);
		payoutRatioMap.put("THRITY_ONE", THIRTY_FIVE);
		payoutRatioMap.put("THRITY_TWO", THIRTY_FIVE);
		payoutRatioMap.put("THRITY_THREE", THIRTY_FIVE);
		payoutRatioMap.put("THRITY_FOUR", THIRTY_FIVE);
		payoutRatioMap.put("THRITY_FIVE", THIRTY_FIVE);
		payoutRatioMap.put("THRITY_SIX", THIRTY_FIVE);
		payoutRatioMap.put("ONE_TWO_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWO_THREE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("FOUR_FIVE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("FIVE_SIX_SPLIT", SEVENTEEN);
		payoutRatioMap.put("SEVEN_EIGHT_SPLIT", SEVENTEEN);
		payoutRatioMap.put("EIGHT_NINE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TEN_ELEVEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("ELEVEN_TWELVE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("THIRTEEN_FOURTEEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("FOURTEEN_FIFTEEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("SIXTEEN_SEVENTEEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("SEVENTEEN_EIGHTEEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("NINTEEN_TWENTY_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_TWENTY_ONE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_TWO_TWENTY_THREE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_THREE_TWENTY_FOUR_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_FIVE_TWENTY_SIX_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_SIX_TWENTY_SEVEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_EIGHT_TWETNY_NINE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_NINE_THIRTY_SPLIT", SEVENTEEN);
		payoutRatioMap.put("THIRTY_ONE_THIRTY_THRITY_TWO_SPLIT", SEVENTEEN);
		payoutRatioMap.put("THRITY_TWO_THIRTY_THREE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("THRITY_FOUR_THIRTY_FIVE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("THIRTY_FIVE_THIRTY_SIX_SPLIT", SEVENTEEN);
		payoutRatioMap.put("ONE_FOUR_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWO_FIVE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("THREE_SIX_SPLIT", SEVENTEEN);
		payoutRatioMap.put("FOUR_SEVEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("FIVE_EIGHT_SPLIT", SEVENTEEN);
		payoutRatioMap.put("SIX_NINE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("SEVEN_TEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("EIGHT_ELEVEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("NINE_TWELVE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TEN_THIRTEEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("ELEVEN_FOURTEEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWELVE_FIFTEEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("THIRTEEN_SIXTEEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("FOURTEEN_SEVENTEEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("FIFTEEN_EIGHTEEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("SIXTEEN_NINETEEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("SEVENTEEN_TWENTY_SPLIT", SEVENTEEN);
		payoutRatioMap.put("EIGHTEEN_TWENTY_ONE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("NINETEEN_TWENTY_TWO_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_TWENTY_THREE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_ONE_TWENTY_FOUR_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_TWO_TWENTY_FIVE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_THREE_TWENTY_SIX_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_FOUR_TWENTY_SEVEN_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_FIVE_TWENTY_EIGHT_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_SIX_TWENTY_NINE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_SEVEN_THIRTY_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_EIGHT_THIRTY_ONE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("TWENTY_NINE_THRITY_TWO_SPLIT", SEVENTEEN);
		payoutRatioMap.put("THIRTY_THIRTY_THREE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("THIRTY_ONE_THIRTY_FOUR_SPLIT", SEVENTEEN);
		payoutRatioMap.put("THIRTY_TWO_THIRTY_FIVE_SPLIT", SEVENTEEN);
		payoutRatioMap.put("THIRTY_THREE_THIRTY_SIX_SPLIT", SEVENTEEN);
		payoutRatioMap.put("ONE_TWO_THREE_STREET", ELEVEN);
		payoutRatioMap.put("FOUR_FIVE_SIX_STREET", ELEVEN);
		payoutRatioMap.put("SEVEN_EIGHT_NINE_STREET", ELEVEN);
		payoutRatioMap.put("TEN_ELEVEN_TWELVE_STREET", ELEVEN);
		payoutRatioMap.put("THIRTEEN_FOURTEEN_FIFTEEN_STREET", ELEVEN);
		payoutRatioMap.put("SIXTEEN_SEVENTEEN_EIGHTEEN_STREET", ELEVEN);
		payoutRatioMap.put("NINETEEN_TWENTY_TWENTY_ONE_STREET", ELEVEN);
		payoutRatioMap.put("TWENTY_TWO_TWENTY_THREE_TWENTY_FOUR_STREET", ELEVEN);
		payoutRatioMap.put("TWENTY_FIVE_TWENTY_SIX_TWENTY_SEVEN_STREET", ELEVEN);
		payoutRatioMap.put("TWENTY_EIGHT_TWENTY_NINE_THIRTY_STREET", ELEVEN);
		payoutRatioMap.put("THIRTY_ONE_THIRTY_TWO_THIRTY_THREE_STREET", ELEVEN);
		payoutRatioMap.put("THIRTY_FOUR_THRITY_FIVE_THIRTY_SIX_STREET", ELEVEN);
		payoutRatioMap.put("ONE_2_4_5_CORNER", EIGHT);
		payoutRatioMap.put("TWO_3_5_6_CORNER", EIGHT);
		payoutRatioMap.put("FOUR_5_7_8_CORNER", EIGHT);
		payoutRatioMap.put("FIVE_6_8_9_CORNER", EIGHT);
		payoutRatioMap.put("SEVEN_8_10_11_CORNER", EIGHT);
		payoutRatioMap.put("EIGHT_9_11_12_CORNER", EIGHT);
		payoutRatioMap.put("TEN_11_13_14_CORNER", EIGHT);
		payoutRatioMap.put("ELEVEN_12_14_15_CORNER", EIGHT);
		payoutRatioMap.put("THIRTEEN_14_16_17_CORNER", EIGHT);
		payoutRatioMap.put("FOURTEEN_15_17_18_CORNER", EIGHT);
		payoutRatioMap.put("SIXTEEN_17_19_20_CORNER", EIGHT);
		payoutRatioMap.put("SEVENTEEN_18_20_21_CORNER", EIGHT);
		payoutRatioMap.put("NINETEEN_20_22_23_CORNER", EIGHT);
		payoutRatioMap.put("TWENTY_21_23_24_CORNER", EIGHT);
		payoutRatioMap.put("TWENTY_TWO_23_25_26_CORNER", EIGHT);
		payoutRatioMap.put("TWENTY_THREE_24_26_27_CORNER", EIGHT);
		payoutRatioMap.put("TWENTY_FIVE_26_28_29_CORNER", EIGHT);
		payoutRatioMap.put("TWENTY_SIX_27_29_30_CORNER", EIGHT);
		payoutRatioMap.put("TWENTY_EIGHT_29_31_32_CORNER", EIGHT);
		payoutRatioMap.put("TWENTY_NINE_30_32_33_CORNER", EIGHT);
		payoutRatioMap.put("THIRTY_ONE_32_34_35_CORNER", EIGHT);
		payoutRatioMap.put("THIRTY_TWO_33_35_36_CORNER", EIGHT);
		payoutRatioMap.put("ONE_4_SIXLINE", FIVE);
		payoutRatioMap.put("FOUR_7_SIXLINE", FIVE);
		payoutRatioMap.put("SEVEN_10_SIXLINE", FIVE);
		payoutRatioMap.put("TEN_13_SIXLINE", FIVE);
		payoutRatioMap.put("THIRTEEN_16_SIXLINE", FIVE);
		payoutRatioMap.put("SIXTEEN_19_SIXLINE", FIVE);
		payoutRatioMap.put("NINETEEN_22_SIXLINE", FIVE);
		payoutRatioMap.put("TWENTY_TWO_25_SIXLINE", FIVE);
		payoutRatioMap.put("TWENTY_FIVE_28_SIXLINE", FIVE);
		payoutRatioMap.put("TWENTY_EIGHT_31_SIXLINE", FIVE);
		payoutRatioMap.put("THIRTY_ONE_34_SIXLINE", FIVE);
		payoutRatioMap.put("ZERO_1_2_TRIO", ELEVEN);
		payoutRatioMap.put("ZERO_2_3_TRIO", ELEVEN);
		payoutRatioMap.put("ZERO_1_2_BASKET", ELEVEN);
		payoutRatioMap.put("ZERO_00_2_BASKET", ELEVEN);
		payoutRatioMap.put("DOUBLE_ZERO_2_3_BASKET", ELEVEN);
		payoutRatioMap.put("TOPLINE", SIX);
	}

	private Ratio(){
		super();
	}
	
	public static int getRatio(String enumValue){
		return payoutRatioMap.get(enumValue).intValue();
	}
	
}
