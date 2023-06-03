package com.validation;

import lombok.Data;
import lombok.Getter;

public class BankAccountPin {
	public static int id;
	@Getter private final String accountNumber;
	protected int bank_account_id = 0;
	@Getter private String pin = "";
	public BankAccountPin(String accountNumber, String pin){
		id++;
		this.accountNumber = accountNumber;
		this.pin = pin;
	}
	public BankAccountPin(int bank_account_id, String accountNumber, String pin){
		id++;
		this.accountNumber = accountNumber;
		this.pin = pin;
	}
}
