package com.bank.account;

public class CurrentAccount extends BankAccount {

	public CurrentAccount(String firstname, String middlename, String lastname) {
		super(firstname, middlename, lastname);
		System.out.println("CurrentAccount Constructor");
		this.setAccType('C');
	}

}
