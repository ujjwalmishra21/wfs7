package com.hsbc.day4;

import java.util.Scanner;
/*
 * 	Program showing usage of NegativeArraySizeException, ArrayIndexOutOfBoundsException, 
 *	StringIndexOutOfBoundsException, IndexOutOfBoundsException, NullPointerException,          
 *	ArithmeticException and print the stack trace for each exception
 */

public class Solution54 {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int arr[] = null;
		System.out.println("Enter size of array to input: ");
		int size = sc.nextInt();
		try {
			arr = new int[size];
			
			System.out.println("Enter array element:");
			for(int i = 0; i < size; i++)
				arr[i] = sc.nextInt();
			System.out.println();
			
			try {
				System.out.println("Element 100th Array: " + arr[100]);
			}catch(ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
			System.out.println();
			
			try {
				display(arr);
			}catch(ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
			System.out.println();
			
		}catch(NegativeArraySizeException e) {
			e.printStackTrace();
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		String string = "Hello World! This is an exception";
		
		try {
			System.out.println("Character at 100th index: " + string.charAt(100));
			
		}catch(StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		try {
			int num = 1/0;
			System.out.println("Result 1/0: " + num);
		}catch(ArithmeticException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		System.out.println("**********************Program Ends*****************************");
	}
	public static void display(int arr[]) throws ArrayIndexOutOfBoundsException{
		System.out.println("Array:");
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}
	

}
