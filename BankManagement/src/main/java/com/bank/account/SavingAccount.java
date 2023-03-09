package com.bank.account;

public class SavingAccount extends BankAccount {

	public SavingAccount(String firstname, String middlename, String lastname) {
		super(firstname, middlename, lastname);
		this.setAccType('S');
		System.out.println("SavingAccount Constructor");
	}
}
