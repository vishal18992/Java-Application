package org.bank;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import com.bank.account.*;

public class Main {

	public static HashMap<String,Object> object_by_account = new HashMap<String, Object>();
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
				Map<String, String> data1;
				data = BankAccount.registerAccount();
				String firstName1 = data.get("firstName");
				String middleName1 = data.get("middleName");
				String lastname1 = data.get("lastName");
				BankAccount currAcc = new CurrentAccount(firstName1, middleName1, lastname1);
				object_by_account.put(currAcc.getAccountNumber(), currAcc);
				break;
			case 3:
				String message = "";
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter Your Account Number: ");
				String accountNumber = sc1.nextLine();
				System.out.println("Enter Your Pin: ");
				String pin = sc1.nextLine();
				if(!BankAccount.validatePin(pin)) {
					message = "Pin is not valid!!!";
				}
				Object obj = object_by_account.get(accountNumber);
				if(obj instanceof SavingAccount){
					SavingAccount sv = (SavingAccount) obj;
					message = sv.registerPin(accountNumber, pin);
				}
				System.out.println(message);
				break;
			case 4:
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Enter Your Account Number: ");
				String accN = sc2.nextLine();
				System.out.println("Enter Your Pin: ");
				String pin2 = sc2.nextLine();
				if(!BankAccount.validatePin(pin2)) {
					message = "Pin is not valid!!!";
				}
		}
		return true;
	}
	public static void main(String[] args) {
		int input;
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		do {
			System.out.println("1) Register Saving Account\n2) Register Current Account\n" +
					"3) Register PIN\n4) Deposit Money\n5) Withdraw Money\n0) Exit");
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