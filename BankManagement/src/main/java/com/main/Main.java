package com.main;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.exception.AccountNotFoundException;
import com.models.Employee;
import com.opencsv.CSVWriter;
import com.opencsv.CSVParser;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParserBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.services.*;
//import com.thread.Transaction;
import com.thread.TransactionThread;

import com.opencsv.CSVReader;
import com.thread.TransactionWriterThread;

public class Main {

	protected static String fileName = "bank-application.csv";
	protected static String filePath = "/tmp/";
	public static HashMap<String, Object> object_by_account = new HashMap<String, Object>();

	private static Object getBankAccount(String accountNumber) throws NullPointerException {
		BankAccount bank = null;
		bank = (BankAccount) object_by_account.get(accountNumber);
		return bank;
	}

	public static String getAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Account Number: ");
		return sc.nextLine();
	}

	public static String getPin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Pin: ");
		return sc.nextLine();
	}

	public static float getAmount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Amount: ");
		return sc.nextFloat();
	}

	public static void saveData() {
		for (Map.Entry<String, Object> set :
				object_by_account.entrySet()) {
			Object obj = set.getValue();
			if (obj instanceof SavingAccount) {
				SavingAccount sv = (SavingAccount) obj;
//				Main.create(sv.getValues());
			}
			if (obj instanceof CurrentAccount) {
				CurrentAccount ca = (CurrentAccount) obj;
//				Main.create(ca.getValues());
			}
		}
	}

	public static void create(String[] values) {
		String str = String.format("%s%s", Main.filePath, Main.fileName);
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(str, true));
			writer.writeNext(values, false);
			writer.close();
		} catch (IOException ex) {
			System.out.println("Exception " + ex);
		}
	}

	public static void searchRead() throws FileNotFoundException {
		String str = String.format("%s%s", Main.filePath, Main.fileName);
			CSVParser csvParser = new CSVParserBuilder().withSeparator(',')
					.withIgnoreQuotations(true)
					.build();
			CSVReader csvReader = new CSVReaderBuilder(new FileReader(str)).withSkipLines(0)
					.withCSVParser(csvParser)
					.build();
	}

	public static boolean printMenu(int input){
		switch(input) {
			case 1:
				Map<String, String> data;
				data = BankAccount.registerAccount();
				String firstName = data.get("firstName");
				String middleName = data.get("middleName");
				String lastname = data.get("lastName");
				BankAccount savingAcc = new SavingAccount(firstName, middleName, lastname);
				int newRecord  = savingAcc.create(savingAcc.getCreateQuery(), savingAcc.getValues());
				System.out.println("New Record: " + newRecord);
				break;
			case 2:
				data = BankAccount.registerAccount();
				firstName = data.get("firstName");
				middleName = data.get("middleName");
				lastname = data.get("lastName");
				BankAccount currAcc = new CurrentAccount(firstName, middleName, lastname);
				object_by_account.put(currAcc.getAccountNumber(), currAcc);
				break;
			case 3:
				String message = "";
				String accountNumber = Main.getAccount();
				String pinNumber = Main.getPin();
				if(!BankAccount.validatePin(pinNumber)) {
					message = "Pin is not valid!!!";
					System.out.println(message);
					break;
				}
				Object obj = object_by_account.get(accountNumber);
				if(obj instanceof SavingAccount){
					SavingAccount sv = (SavingAccount) obj;
					try{
						sv.registerPin(accountNumber, pinNumber);
					}catch (AccountNotFoundException ex) {
						System.out.println("Account is not found!!" + accountNumber);
					}
				}
				break;
			case 4:
				accountNumber = Main.getAccount();
				pinNumber = Main.getPin();
				if(!BankAccount.validatePin(pinNumber)) {
					System.out.println("Your Pin is not valid");
					break;
				}
				BankAccount bank;
				bank = (BankAccount) Main.getBankAccount(accountNumber);
				if (bank == null) {
					break;
				}
				float amount = Main.getAmount();
				bank.depositMoney(amount, pinNumber);
				break;
			case 5:
				accountNumber = Main.getAccount();
				pinNumber = Main.getPin();
				if(!BankAccount.validatePin(pinNumber)) {
					System.out.println("Your Pin is not valid");
					break;
				}
				bank = (BankAccount) Main.getBankAccount(accountNumber);
				if (bank == null) {
					break;
				}
				amount = Main.getAmount();
				bank.withdrawMoney(amount, pinNumber);
				break;
			case 6:
				accountNumber = Main.getAccount();
				pinNumber = Main.getPin();
				bank = (BankAccount) Main.getBankAccount(accountNumber);
				if (bank == null) {
					break;
				}
				if(bank.verifyPin(pinNumber)){
					bank.viewBalance(pinNumber);
				}
				break;
			case 7:
				BlockingQueue<Employee> queue = new ArrayBlockingQueue<Employee>(500);

				TransactionThread r1 = new TransactionThread(queue);
				new Thread(r1, "Read Transaction").start();

				TransactionWriterThread normalizers = new TransactionWriterThread(queue);
//				Thread t2 = new Thread(normalizers, "Write Transaction 1");
				ExecutorService executor = Executors.newFixedThreadPool(3);
				for (int i = 1; i <= 3; i++) {
					executor.submit(normalizers);
				}
				break;
		}
		return true;
	}

	public static void main(String[] args) {
		int input;
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		do {
			System.out.println("1) Register Saving Account\n2) Register Current Account\n" +
					"3) Register PIN\n4) Deposit Money\n5) Withdraw Money\n6) View Balance\n7) Read Transaction\n0) Exit\nEnter your input: ");
			if(!flag){
				input = sc.nextInt();
			}else{
				if(!sc.hasNextInt()) {
					Scanner sc1 = new Scanner(System.in);
					input = sc1.nextInt();
				}else{
					input = sc.nextInt();
				}
			}
			flag = Main.printMenu(input);
		}
		while(input != 0);
	}
}
