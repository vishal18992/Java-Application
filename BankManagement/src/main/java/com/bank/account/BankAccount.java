package com.bank.account;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;


public class BankAccount extends Bank {
	BankAccountPin accPin;
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
		return pin != null && !pin.trim().isEmpty();
	}
	public String registerPin(String accountNumber, String pin) {
		System.out.println("Called Register Pin");
		if(!this.isAccountExist(accountNumber)) {
			return "AccountNumber is not exist!!";
		}
		this.accPin = new BankAccountPin(accountNumber, pin);
		return "Register Successfully!!!";
	}
	public boolean verifyPin(String pinNumber) {
		return this.accPin.getPin().equals(pinNumber);
	}
	public void depositMoney(float balance, String pinNumber) {
		if(this.verifyPin(pinNumber)) {
			float bal =  this.getBalance() + balance;
			this.setBalance(bal);
		}
	}
	public void viewBalance(String pinNumber) {
		if(this.verifyPin(pinNumber)){
			super.viewBalance();
		}
	}

	public void withdrawMoney(float amount, String pinNumber){
		if(this.verifyPin(pinNumber)) {
			float balance =  this.getBalance() - amount;
			this.setBalance(balance);
		}
	}

}
