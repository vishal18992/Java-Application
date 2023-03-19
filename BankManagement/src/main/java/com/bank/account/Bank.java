package com.bank.account;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import lombok.Getter;
import lombok.Setter;

abstract class Bank {
	private static final Logger LOGGER = Logger.getLogger("InfoLogging");
	private @Getter static final int ACCOUNT_NUMBER_LENGTH = 16;
	private  @Setter @Getter String accountNumber;
	private @Getter @Setter String firstName;
	private @Getter @Setter String middleName;
	private @Getter @Setter String lastName;
	protected @Getter String accountType;
	private @Getter @Setter float balance = 0f;
	protected @Getter char accType;
	private static AtomicLong sequenceNumber = new AtomicLong(1200044400L);

	Bank(String firstName, String middleName, String lastName) {
		this.accountNumber = Bank.generateAccountNumber();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		System.out.println("Your Account Number is " + this.accountNumber);
	}

	protected static String generateAccountNumber() {
		long code = sequenceNumber.getAndIncrement();
		if (code == 999999999999L) {
			sequenceNumber = new AtomicLong(1200044400L);
			code = sequenceNumber.getAndIncrement();
		}
		String logger_msg = "Generated Account Number!!" + code;
		LOGGER.info(logger_msg);
		return String.valueOf(code);
	}
	
	protected boolean isAccountExist(String accountNumber) {
		return this.accountNumber.equals(accountNumber);
	}

	public void depositMoney(float balance, String pinNumber) {}
	public void withdrawMoney(float amount, String pinNumber) {}

	private void registerPin(String accountNumber) {}

	public void viewBalance() {
		System.out.println("Your Balance is " + this.balance);
	}
}
