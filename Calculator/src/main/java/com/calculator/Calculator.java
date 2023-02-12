package com.calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator implements CalcInterface {
	
	final String pattern = "^([0-9]+.[0-9]+[\\+\\-\\*\\/]{1})+[0-9]+.[0-9]+$";
	private ArrayList<String> expression = new ArrayList<String>();

	{
		OPERATOR.add("*");
		OPERATOR.add("/");
		OPERATOR.add("+");
		OPERATOR.add("-");
	}

	public float add(float a, float b) {
		return a + b;
	}

	public float sub(float a, float b) {
		return a - b;
	}

	public float mul(float a, float b) {
		return a * b;
	}

	public float div(float a, float b) {
		return a / b;
	}

	private void setExpression(String exp) {
		String tmp = "";
		for (int i = 0; i < exp.length(); i++) {
			String val = "" + exp.charAt(i);
			if (Calculator.OPERATOR.contains(val)) {
				this.expression.add(tmp);
				this.expression.add(val);
				tmp = "";
			} else if (i == exp.length() - 1) {
				tmp += val;
				this.expression.add(tmp);
			} else {
				tmp += val;
			}
		}
	}

	private ArrayList<String> getExpression() {
		return this.expression;
	}

	public static float strToFloat(String str) {
		return Float.valueOf(str);
	}

	protected float computeExpression(String exp) {
		float ans = 0.0f;
		this.setExpression(exp);
		ArrayList<String> temp = this.getExpression();
		boolean hasOperator = true;
		for (String val : Calculator.OPERATOR) {
			while (hasOperator == true) {
				if (temp.contains(val)) {
					int star_index = temp.indexOf(val);
					float ans1 = 0;
					String lDigit = temp.get(star_index - 1);
					String rDigit = temp.get(star_index + 1);
					if (val.equals("*")) {
						ans1 = this.mul(Calculator.strToFloat(lDigit), Calculator.strToFloat(rDigit));
					} else if (val.equals("/")) {
						ans1 = this.div(Calculator.strToFloat(lDigit), Calculator.strToFloat(rDigit));
					} else if (val.equals("+")) {
						ans1 = this.add(Calculator.strToFloat(lDigit), Calculator.strToFloat(rDigit));
					} else if (val.equals("-")) {
						ans1 = this.sub(Calculator.strToFloat(lDigit), Calculator.strToFloat(rDigit));
					}
					temp.set(star_index, Float.toString(ans1));
					temp.remove(star_index + 1);
					temp.remove(star_index - 1);

				} else {
					hasOperator = false;
				}
			}
			hasOperator = true;
		}
		ans = Calculator.strToFloat(temp.get(0));
		return ans;
	}

	public void getResult(Float value) {
		System.out.println("Answer is : " + value);
	}

	public boolean validateExpressionInput(String input) {
		boolean flag = false;
		try {
			Pattern p = Pattern.compile(this.pattern);
			Matcher m = p.matcher(input);
			flag = m.matches();
		} catch (IllegalArgumentException e) {
			System.out.println("Exception raise your expression is not valid!!.");
		}
		return flag;
	}
}
