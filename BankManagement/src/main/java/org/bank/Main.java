package org.bank;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import com.bank.account.*;

public class Main {

	public static HashMap<String,Object> object_by_account = new HashMap<String, Object>();

	private static Object getBankAccount(String accountNumber){
		BankAccount bank = null;
		try {
			bank = (BankAccount) object_by_account.get(accountNumber);
		}catch (NullPointerException e){
			System.out.println("Account number not found!!!.");
		}
		return bank;
	}
	public static String getAccount(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Account Number: ");
		return  sc.nextLine();
	}
	public static String getPin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Pin: ");
		return sc.nextLine();
	}

	public static float getAmount(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Amount: ");
		return sc.nextFloat();
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
				object_by_account.put(savingAcc.getAccountNumber(), savingAcc);
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
					message = sv.registerPin(accountNumber, pinNumber);
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
		}
		return true;
	}
	public static void main(String[] args) {
		int input;
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		do {
			System.out.println("1) Register Saving Account\n2) Register Current Account\n" +
					"3) Register PIN\n4) Deposit Money\n5) Withdraw Money\n6) View Balance\n0) Exit\nEnter your input: ");
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