package com.services;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.base.Model;

import com.exception.PinNotFoundException;
import lombok.Getter;
import lombok.Setter;

abstract class Bank extends Model implements Serializable {
	protected static final Logger LOGGER = Logger.getLogger("InfoLogging");
	private @Getter static final int ACCOUNT_NUMBER_LENGTH = 16;

	private @Getter int id = 0;
	private  @Setter @Getter String accountNumber;
	private @Getter @Setter String firstName;
	private @Getter @Setter String middleName;
	private @Getter @Setter String lastName;
	private @Getter @Setter float balance = 0.0f;
	protected @Getter @Setter char accType;
	private static AtomicLong sequenceNumber = new AtomicLong(1200044400L);
//	private static final String fileName = "bank-application.csv";
//	private static final String filePath = "/tmp/";

	Bank(String firstName, String middleName, String lastName) {
		this.accountNumber = Bank.generateAccountNumber();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.id += 1;
	}

	protected static String generateAccountNumber() {
		long code = sequenceNumber.getAndIncrement();
		if (code == 999999999999L) {
			sequenceNumber = new AtomicLong(1200044400L);
			code = sequenceNumber.getAndIncrement();
		}
		String logger_msg = "Your Account Number is " + code;
		LOGGER.info(logger_msg);
		return String.valueOf(code);
	}

	public int create(String query, ArrayList params) {
		Connection con = null;
		int result = 0;
		String[] returnId = { "id" };
		try {
			con = this.getConnection();
			String type = String.valueOf(params.get(6));
			PreparedStatement stmt = con.prepareStatement(query, returnId);
			stmt.setString(1,params.get(1).toString());
			stmt.setString(2, params.get(2).toString());
			stmt.setString(3, params.get(3).toString());
			stmt.setString(4, params.get(4).toString());
			stmt.setFloat(5, (Float) params.get(5));
			stmt.setString(6, type);
			if(stmt.executeUpdate() > 0){
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next() ) {
					result = generatedKeys.getInt(1);
				}
			}
			LOGGER.info("Record Created Successfully!!" + String.valueOf(result));
		} catch (SQLException | ClassNotFoundException ex) {
			LOGGER.log(Level.SEVERE,"Record Creation Exception:- " + ex);
		} finally {
			try {
				con.close();
			}catch (SQLException ex){}
		}
		return result;
	}

	
	protected boolean isAccountExist(String accountNumber) {
		return this.accountNumber.equals(accountNumber);
	}

	public void depositMoney(float balance, String pinNumber) {}
	public void withdrawMoney(float amount, String pinNumber) {}

	public void registerPin(String accountNumber) throws PinNotFoundException {}

	public void viewBalance() {
		System.out.println("Your Balance is " + this.balance);
	}

}
