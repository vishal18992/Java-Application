package org.bank;

import java.util.*;
import com.bank.account.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc;
		int input;
		do {
			System.out.println("1) Register Saving Account\n2) Register Current Account\nRegister PIN\n3) Register PIN\n4) Deposit Money\n5) Withdraw Money\n0) Exit");
			sc = new Scanner(System.in);
			if(sc.hasNextInt()) {
				input = sc.nextInt();
			}else {
				sc.close();
				sc = new Scanner(System.in);
				input = sc.nextInt();
			}
			switch(input) {
				case 1:
					Map<String, String> data;
					data = BankAccount.registerAccount();
					String firstName = data.get("firstName");
					String middleName = data.get("middleName");
					String lastname = data.get("lastName");
					BankAccount savingAcc = new SavingAccount(firstName, middleName, lastname);
					break;
				case 2: 
					Map<String, String> data1;
					data = BankAccount.registerAccount();
					String firstName1 = data.get("firstName");
					String middleName1 = data.get("middleName");
					String lastname1 = data.get("lastName");
					BankAccount currAcc = new CurrentAccount(firstName1, middleName1, lastname1);
				case 3:
					String message;
					Scanner sc1 = new Scanner(System.in);
					System.out.println("Enter Your Account Number: ");
					String accountNumber = sc1.nextLine();
					System.out.println("Enter Your Pin: ");
					String pin = sc1.nextLine();
					BankAccount bank = new BankAccount();
					if(!BankAccount.validatePin(pin)) {
						message = "Pin is not valid!!!";
					}
					message = bank.registerPin(accountNumber, pin);
					System.out.println(message);
					sc1.close();
					break;
			}			
		}
		while(input > 0);
		sc.close();
	}

}