package com.rade.jeff.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserIO {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserIO.class);
	
	private static final UserIO SINGLETON = new UserIO();
	
	public static final int EQUAL_TO = 0;
	
	public static final int LESS_THAN = 1;
	
	public static final int MORE_THAN = 2;
	
	public static final int LESS_THAN_EQUAL = 3;
	
	public static final int MORE_THAN_EQUAL = 4;
	
	public static UserIO getInstance(){
		return SINGLETON;
	}
	
	private UserIO(){
		super();
	}
	
	public String userCommunicationHub(String messageToUser, String[] args, String endMessageToUser){
		String input = null;
		
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(messageToUser);
			
			printArrayArg(args);
			
			if(endMessageToUser != null){
				System.out.println(endMessageToUser);
			}
			
			input = in.readLine();
		} catch (Exception ex){
			LOG.error("Exception in UserIO.userCoomunicationHub: ");
			ex.printStackTrace();
		}
		
		return input;				
	}
	
	public String userCommunicationHubIntValidation(String messageToUser, String[] args, String endMessageToUser, int validator, int comparison){
		String input = null;
		boolean done = false;
		
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			while(!done){
				System.out.println(messageToUser);
	
				printArrayArg(args);
				
				if(endMessageToUser != null){
					System.out.println(endMessageToUser);
				}
				
				input = in.readLine();			
				done = validateInt(Integer.valueOf(input).intValue(), validator, comparison);
				if(!done){
					printErrorMessage(validator, comparison);
				}
			}
			
		} catch (Exception ex){
			LOG.error("Exception in UserIO.userCommunicationHub: ", ex);
		}
		
		return input;				
	}

	private void printArrayArg(String[] args) {
		if(args != null){
			for(int i = 1; i < args.length + 1; i++){
				if(i % 10 == 0){
					System.out.println(args[i - 1]);
				} else {
					System.out.println(args[i - 1]);
				}
			}
		}
	}

	private static void printErrorMessage(int validator, int comparison) {
		if(comparison == LESS_THAN){
			System.out.println("You must choose a number less than " + validator);
		} else if(comparison == MORE_THAN){
			System.out.println("You must choose a number more than " + validator);
		} else if(comparison == LESS_THAN_EQUAL){
			System.out.println("You must choose a number less than or equal to " + validator);
		} else if(comparison == MORE_THAN_EQUAL){
			System.out.println("You must choose a number more than or equal to  " + validator);
		} else if(comparison == EQUAL_TO){
			System.out.println("You must choose a number equal to " + validator);
		} else{
			LOG.error("Should not be here");
		}
	}

	private static boolean validateInt(int intValue, int validator, int comparison) {
		boolean pass = false;
	
		if(comparison == LESS_THAN){
			if(intValue < validator){
				pass = true;
			}
		}
		else if(comparison == MORE_THAN){
			if(intValue > validator){
				pass = true;
			}
		}
		else if(comparison == LESS_THAN_EQUAL){
			if(intValue <= validator){
				pass = true;
			}
		}
		else if(comparison == MORE_THAN_EQUAL){
			if(intValue >= validator){
				pass = true;
			}
		}
		else if(comparison == EQUAL_TO){
			if(intValue == validator){
				pass = true;
			}
		}
	
		return pass;
	}
	
	public void printMessageToUser(String message){
		System.out.println(message);
	}
}