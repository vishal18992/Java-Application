package com.calculator;

import java.util.ArrayList;

public abstract interface CalcInterface {

	final static ArrayList<String> OPERATOR = new ArrayList<String>();

	/* Addition */
	abstract float add(float a, float b);

	/* Subtraction */
	abstract float sub(float a, float b);

	/* Multiplication */
	abstract float mul(float a, float b);

	/* Division */
	abstract float div(float a, float b);

	abstract boolean validateExpressionInput(String input);

	abstract void getResult(Float value);

}
