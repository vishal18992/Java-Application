package com.calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Enter your Expression:-  ");
			input = new String();
			input = sc.nextLine();
			Calculator c = new Calculator();
			if (!c.validateExpressionInput(input)) {
				if (!input.equals("exit")) {
					System.out.println("Something wrong!. Your expression is not valid.");
				}
				continue;
			}
			float ans = c.computeExpression(input);
			c.getResult(ans);
		} while (!input.equals("exit"));
		System.out.println("Closed..");
		sc.close();
	}

}
