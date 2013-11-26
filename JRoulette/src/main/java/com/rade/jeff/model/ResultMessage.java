package com.rade.jeff.model;

import java.math.BigDecimal;

public class ResultMessage {
	
	private Integer spinResult;
	
	private String payoutMessage;
	
	private Integer totalMoney;

	public Integer getSpinResult() {
		return spinResult;
	}

	public void setSpinResult(Integer spinResult) {
		this.spinResult = spinResult;
	}

	public String getPayoutMessage() {
		return payoutMessage;
	}

	public void setPayoutMessage(String payoutMessage) {
		this.payoutMessage = payoutMessage;
	}

	public Integer getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Integer totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	@Override
	public String toString(){
		return spinResult+ ", " + payoutMessage + ", " + totalMoney;
	}

}
