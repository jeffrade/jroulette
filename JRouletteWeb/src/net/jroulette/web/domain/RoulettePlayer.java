package net.jroulette.web.domain;

public class RoulettePlayer {
	
	private String userName;
	
	private String email;
	
	private String money;
	
	private String table;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}	
}