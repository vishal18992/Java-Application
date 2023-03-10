package com.bank.account;

import java.util.*;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

public class BankAccount extends Bank {
	BankAccountPin accPin;

	BankAccount() {
	}
	BankAccount(String firstName, String middleName, String lastName) {
		super(firstName, middleName, lastName);
	}

	public static Map<String, String> registerAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your First Name: ");
		String firstName = sc.nextLine();
		System.out.println("Enter Your Second Name: ");
		String middleName = sc.nextLine();
		System.out.println("Enter Your Third Name: ");
		String lastName = sc.nextLine();
		Map<String, String> accountInformation = new HashMap<String, String>();
		accountInformation.put("firstName", firstName);
		accountInformation.put("middleName", middleName);
		accountInformation.put("lastName", lastName);
		System.out.println(accountInformation);
		return accountInformation;
	}

	protected void setAccType(char accType) {
		this.accType = accType;
	}

	public static Boolean validatePin(String pin) {
		Boolean falg = false;
		if (pin != null && !pin.trim().isEmpty()) {
			falg = true;
		}
		return falg;
	}

	public String registerPin(String accountNumber, String pin) {
		System.out.println("Called Register Pin");
		if(!this.isAccountExist(accountNumber)) {
			return "AccountNumber is not exist!!";
		}
		BankAccountPin newpin = new BankAccountPin(accountNumber, pin);
		this.accPin = newpin;
		return "Register Successfully!!!";
	}
	private boolean verifyPin(String pinNumber) {
		boolean flag = false;
		if(this.accPin.getPin().equals(pinNumber)){
			flag = true;
		}
		return flag;
	}
	public void dipositMoney(float balance, String pinNumber) {
		float bal =  this.getBalance() + balance;
		if(this.verifyPin(pinNumber)) {
			this.setBalance(bal);
		}
	}
}
