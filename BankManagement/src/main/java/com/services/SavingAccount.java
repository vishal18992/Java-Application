package com.services;

import com.exception.PinNotFoundException;
import com.validation.BankAccountPin;

public class SavingAccount extends BankAccount {

	public SavingAccount(String fName, String mName, String lName) {
		super(fName, mName, lName);
		this.setAccType('S');
	}
}
