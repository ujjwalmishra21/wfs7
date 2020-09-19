package com.hsbc.day4;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * Program showing division with finally block (Exception handling)
 * to depict that program ended (successfully or with an exception)
 */
public class Solution56 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		CalculatorNew calc = null;
		long firstNumber = 0;
		long secondNumber = 0;
		
		try {
			System.out.println("Enter first integer number: ");
			firstNumber = sc.nextLong();
			
		}catch(InputMismatchException e) {
			e.printStackTrace();
			
		}
		System.out.println();
		try {
			System.out.println("Enter second integer number: ");
			secondNumber = sc.nextLong();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		try {
			calc = new CalculatorNew(firstNumber, secondNumber);
			long result = calc.div();
			System.out.println("Result: " + result);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}finally {
			calc = null;
			System.out.println("*********************Operation Complete*******************");
		}
	}
}
/*
 * Calculator class contains:
 * add(a,b) - prints sum of a and b (a+b)
 * diff(a,b) - prints subtraction of a and b (a-b)
 * mult(a,b) - prints multiplcation of a and b (a-b)
 * div(a,b) - prints division a by b (a/b)
 */
class CalculatorNew{
	private long firstNumber;
	private long secondNumber;
	
	public CalculatorNew() {
		super();
		this.firstNumber = 0;
		this.secondNumber = 0;
	}
		
	public CalculatorNew(long firstNumber, long secondNumber) {
		super();
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	public long div() throws ArithmeticException {
		long division = this.firstNumber / this.secondNumber;
		return division;
	}
}