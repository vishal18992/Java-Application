package com.bank.account;

import lombok.Data;
import lombok.Getter;

public class BankAccountPin {
	public static int id;
	@Getter private final String accountNumber;
	@Getter private String pin = "";
	public BankAccountPin(String accountNumber, String pin){
		id++;
		this.accountNumber = accountNumber;
		this.pin = pin;
	}
}
