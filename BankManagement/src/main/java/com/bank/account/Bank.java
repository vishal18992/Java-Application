package com.bank.account;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import lombok.Getter;
import lombok.Setter;

abstract class Bank {
	private static Logger LOGGER = Logger.getLogger("InfoLogging");
	private @Getter static final int ACCOUNT_NUMBER_LENGTH = 16;
	private  @Setter @Getter String accountNumber;
	private @Getter @Setter String firstName;
	private @Getter @Setter String middleName;
	private @Getter @Setter String lastName;
	private @Getter String accountType;
	private @Getter @Setter float balance = 0f;
	protected @Getter char accType;
	private static AtomicLong sequenceNumber = new AtomicLong(000000000001L);

	Bank() {}

	Bank(String firstName, String middleName, String lastName) {
		this.accountNumber = Bank.genereteAccountNumber();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		System.out.println("Your Account Number is " + this.accountNumber);
	}

	protected static String genereteAccountNumber() {
		long code = sequenceNumber.getAndIncrement();
		if (code == 999999999999L) {
			sequenceNumber = new AtomicLong(000000000001L);
			code = sequenceNumber.getAndIncrement();
		}
		String logger_msg = "Generated Account Number!!" + code;
		LOGGER.info(logger_msg);
		return String.valueOf(code);
	}
	
	protected boolean isAccountExist(String accountNumber) {
		boolean flag  = false;
		if(this.accountNumber.equals(accountNumber)) {
			flag = true;
		}
		return flag;
	}

	public void dipositMoney() {}

	private String registerPin(String accountNumber) {return null;}

	public float viewBalance() {
		return this.balance;
	}
}
