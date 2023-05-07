package com.services;

public class CurrentAccount extends BankAccount {

	public CurrentAccount(String firstName, String middleName, String lastName) {
		super(firstName, middleName, lastName);
		this.setAccType('C');
	}

}
