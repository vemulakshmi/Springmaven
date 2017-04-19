package com.byteslounge.model;


public class Account {

	private final String accountNumber;
	private String accountDescription;

	public Account(String accountNumber, String accountDescription) {
		this.accountNumber = accountNumber;
		this.accountDescription = accountDescription;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAccountDescription() {
		return accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

}
