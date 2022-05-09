import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	// test methods
	@Test
	public void testAdditionPositive() {
		Calculator calc = new Calculator();
		
		// actual output
		int actualOutput = calc.addition(4, 3);
		// expected output
		int expectedOutput = 7;
		// check if expected output is equal to actual output
		assertEquals(expectedOutput, actualOutput);
	
	}
	
	
	@Test
	public void testAdditionNegative() {
		Calculator calc = new Calculator();
		int actualOutput = calc.addition(-8, -2);
		int expectedOutput = -10;
		assertEquals(expectedOutput, actualOutput);
	}
}
