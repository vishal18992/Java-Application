package com.bank.account;

public class SavingAccount extends BankAccount {

	public SavingAccount(String fName, String mName, String lName) {
		super(fName, mName, lName);
		this.setAccType('S');
		System.out.println("SavingAccount Constructor");
	}
}
