package com.hsbc.day4;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * Calculator program with exception handling
 */
public class Solution50 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter number for operation:\n 1 - Add \n 2 - Subtract \n 3 - Multiplication \n 4 - Division");
		int op = -1;
		long firstNumber  = 0;
		long secondNumber = 0;
		try {
			op = sc.nextInt();
			try {
				System.out.println("Enter first integer number: ");
				firstNumber = sc.nextLong();
			}catch(InputMismatchException e) {
				e.printStackTrace();
				op = 0;
			}
			System.out.println();
			try {
				System.out.println("Enter second integer number: ");
				secondNumber = sc.nextLong();
			}catch(InputMismatchException e) {
				e.printStackTrace();
				op = 0;
			}
			System.out.println();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}
		
		Calculator calc = new Calculator();
		switch(op) {
			case 0:
				System.out.println("Invalid operands");
				break;
			case 1:
				calc.add(firstNumber, secondNumber);
				break;
			case 2:
				calc.diff(firstNumber, secondNumber);
				break;
			case 3:
				calc.mult(firstNumber, secondNumber);
				break;
			case 4:
				calc.div(firstNumber, secondNumber);
				break;
			default:
				System.out.println("Invalid operation");
				break;
			
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
class Calculator{
	public void add(long firstNumber, long secondNumber) {
		long sum = firstNumber + secondNumber;
		System.out.println(firstNumber + " + " + secondNumber +" = " + sum);
	}
	public void diff(long firstNumber, long secondNumber) {
		long difference = firstNumber - secondNumber;
		System.out.println(firstNumber + " - " + secondNumber +" = " + difference);
	}
	public void mult(long firstNumber, long secondNumber) {
		long product = firstNumber * secondNumber;
		System.out.println(firstNumber + " * " + secondNumber +" = " + product);
	}
	public void div(long firstNumber, long secondNumber){
		long division = -1;
		try {
			division = firstNumber / secondNumber;
			System.out.println(firstNumber + " / " + secondNumber +" = " + division);
		}catch (ArithmeticException e) {
			e.printStackTrace();
		}
				
	}
}
