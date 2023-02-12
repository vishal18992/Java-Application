package com.junit.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.calculator.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class CalculatorTest {
	
	Calculator calculator;
	
	@BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Created calculator object!!!!");
    }

//	@Test
//	@DisplayName("Simple addition should work") 
//	public void testAddition() {
//		assertEquals(20.0f, calculator.add(4.0f, 6.0f), "Regular addition should work");
//	}
//	
	@RepeatedTest(1)
    @DisplayName("Ensure correct handling of arithmetic operations..")
    void testMultiplyWithZero() {
        assertEquals(0.0f, calculator.mul(0.f, 5.f), "Multiple with zero should be zero");
        assertEquals(6.0f, calculator.add(5.f, 1.f), "Addition result is expected 6.0.");
    }

}
