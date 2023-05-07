package com.services;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import com.opencsv.*;

import com.exception.PinNotFoundException;
import lombok.Getter;
import lombok.Setter;

abstract class Bank implements Serializable {
	protected static final Logger LOGGER = Logger.getLogger("InfoLogging");
	private @Getter static final int ACCOUNT_NUMBER_LENGTH = 16;

	private @Getter int id = 0;
	private  @Setter @Getter String accountNumber;
	private @Getter @Setter String firstName;
	private @Getter @Setter String middleName;
	private @Getter @Setter String lastName;
	private @Getter @Setter float balance = 0f;
	protected @Getter @Setter char accType;
	private static AtomicLong sequenceNumber = new AtomicLong(1200044400L);
	private static String fileName = "bank-application.csv";
	private static String filePath = "/tmp/";

	Bank(String firstName, String middleName, String lastName) {
		this.accountNumber = Bank.generateAccountNumber();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.id += 1;
	}

//	public void create(){
//		String str  = String.format("%s%s", this.filePath, this.fileName);
//		try{
//			CSVWriter writer = new CSVWriter(new FileWriter(str, true));
//			String[] record = String.format("%s,%s,%s,%s,%s", this.id,this.getAccountNumber(),
//					this.getFirstName(), this.getMiddleName() ,this.getLastName()).split(",");
//			writer.writeNext(record, false);
//			writer.close();
//		}catch (IOException ex){
//			System.out.println("Exception " + ex);
//		}
//	}

//	public Boolean write(String val) throws IOException{
//		String str  = String.format("%s%s", this.filePath, this.fileName);
//		CSVWriter writer = new CSVWriter(new FileWriter(str));
//		return true;
//	}

//	public void read(String accountNumber) throws IOException {
//		String str  = String.format("%s%s", this.filePath, this.fileName);
//		CSVWriter writer = new CSVWriter(new FileWriter(str));
//		CSVParser csvParser = new CSVParserBuilder().withSeparator(',')
//				.withIgnoreQuotations(true)
//				.build();
//		CSVReader csvReader = new CSVReaderBuilder(new FileReader(str)).withSkipLines(0)
//				.withCSVParser(csvParser)
//				.build();
//
//		String[] nextLine;
//		while ((nextLine = csvReader.readNext()) != null) {
//			if (nextLine != null) {
//				//Verifying the read data here
//				System.out.println(Arrays.toString(nextLine));
//			}
//		}
//	}

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

	
	protected boolean isAccountExist(String accountNumber) {
		return this.accountNumber.equals(accountNumber);
	}

	public void depositMoney(float balance, String pinNumber) {}
	public void withdrawMoney(float amount, String pinNumber) {}

	private void registerPin(String accountNumber) throws PinNotFoundException {}

	public void viewBalance() {
		System.out.println("Your Balance is " + this.balance);
	}
}
