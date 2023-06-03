package com.services;

import com.exception.AccountNotFoundException;
import com.validation.BankAccountPin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


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
		return accountInformation;
	}

	private String getPinNumber(){
		return this.accPin.getPin();
	}
	public void setAccType(char accType) {
		this.accType = accType;
	}
	public static Boolean validatePin(String pin) {
		return pin != null && !pin.trim().isEmpty();
	}
	public void registerPin(String accountNumber, String pin) throws AccountNotFoundException {
		if(!this.isAccountExist(accountNumber)) {
			throw new AccountNotFoundException(String.format("AccountNumber %s is not exist!!", accountNumber));
		}
		this.accPin = new BankAccountPin(accountNumber, pin);
		LOGGER.info("Pin Registered Successfully!!");
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
	public ArrayList getValues(){
		String pin = null;
		if(this.accPin != null){
			pin = this.getPinNumber();
		}
		ArrayList record = new ArrayList(8);
		record.add(this.getId());
		record.add(this.getAccountNumber());
		record.add(this.getFirstName());
		record.add(this.getMiddleName());
		record.add(this.getLastName());
//		record.add(pin);
		record.add(this.getBalance());
		record.add(this.getAccType());
		return record;
	}

	public String getCreateQuery(){
		String query = "INSERT INTO bank_accounts (accountNumber, firstName, middleName, lastName, balance, accType) VALUES(?,?,?,?,?,?);";
		return query;
	}
}
