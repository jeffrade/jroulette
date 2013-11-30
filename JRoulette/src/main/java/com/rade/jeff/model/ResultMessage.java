package com.rade.jeff.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a class to hold message objects to return to client as json
 * 
 * @author jer3321
 */
public class ResultMessage {
	
	private Integer spinResult;
	
	private List<String> payoutMessages;
	
	private Integer totalMoney;
	
	private String message;
	
	private List<String> numberHistory;
	
	private List<String> colorHistory;

	public ResultMessage() {
		super();
	}

	public ResultMessage(String message) {
		super();
		this.message = message;
	}

	public Integer getSpinResult() {
		return spinResult;
	}

	public void setSpinResult(Integer spinResult) {
		this.spinResult = spinResult;
	}

	public List<String> getPayoutMessages() {
		return payoutMessages;
	}

	public void setPayoutMessages(List<String> payoutMessages) {
		this.payoutMessages = payoutMessages;
	}

	public Integer getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Integer totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<String> getNumberHistory() {
		return numberHistory;
	}

	public void setNumberHistory(List<String> numberHistory) {
		this.numberHistory = numberHistory;
	}

	public void addNumberHistory(String number){
		if(numberHistory == null) {
			this.numberHistory = new ArrayList<String>();
		}
		this.numberHistory.add(number);
	}

	public List<String> getColorHistory() {
		return colorHistory;
	}

	public void setColorHistory(List<String> colorHistory) {
		this.colorHistory = colorHistory;
	}

	public void addColorHistory(String color){
		if(colorHistory == null) {
			this.colorHistory = new ArrayList<String>();
		}
		this.colorHistory.add(color);
	}

	@Override
	public String toString() {
		return "ResultMessage ["
			+ (spinResult != null ? "spinResult=" + spinResult + ", " : "")
			+ (payoutMessages != null ? "payoutMessages=" + payoutMessages + ", " : "")
			+ (totalMoney != null ? "totalMoney=" + totalMoney + ", " : "")
			+ (message != null ? "message=" + message + ", " : "")
			+ (numberHistory != null ? "numberHistory=" + numberHistory + ", " : "")
			+ (colorHistory != null ? "colorHistory=" + colorHistory : "")
			+ "]";
	}

}
