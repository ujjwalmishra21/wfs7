package com.hsbc.day4;

import java.util.Scanner;
/*
 * String manipulation operations with Exception Handling
 */
public class Solution51 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		try {
			String sampleStr = "The quick brown fox jumps over the lazy dog";
		
			try {
				System.out.println("Character at 12th index: " + sampleStr.charAt(12) + "\n");
			}catch (StringIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("Whether given string contains is: " + sampleStr.contains("is") + "\n");
			
			
			StringBuilder stringBuilder = new StringBuilder(sampleStr);
			stringBuilder.append(" and killed it");
			
			System.out.println("Appending string to original string:" + stringBuilder + "\n");
			
			System.out.println("Whether given string ends with 'dog': " + sampleStr.endsWith("dog") + "\n");
			
			System.out.println("Whether given string equals the mentioned string 1: " + sampleStr.equals("The quick brown Fox jumps over the lazy Dog") +"\n");
			
			System.out.println("Whether given string equals the mentioned string 2: " + sampleStr.equals("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG") +"\n");
			
			System.out.println("Index of character 'a': " + sampleStr.indexOf('a') +"\n");
			
			System.out.println("Last Index of character 'e': " + sampleStr.lastIndexOf('e') +"\n");
			
			System.out.println("Replace 'The' with 'A': " + sampleStr.replace("The", "A") +"\n");
			
			System.out.println("Length of string: " + sampleStr.length() +"\n");
			try {
				int foxIndex = sampleStr.indexOf("fox");
				String stringPart1 = sampleStr.substring(0, foxIndex + 3);
				String stringPart2 = sampleStr.substring(foxIndex+3).trim();
				
				System.out.println("String on splitting:");
				System.out.println("Part 1: " + stringPart1);
				System.out.println("Part 2: " + stringPart2);
			}catch(StringIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
			System.out.println();
						
			int startIndex = sampleStr.indexOf("fox");
			try {
				String animal1 = sampleStr.substring(startIndex, startIndex + 3);
				
				startIndex = sampleStr.indexOf("dog");
				String animal2 = sampleStr.substring(startIndex, startIndex + 3);
				
				System.out.println("Animal names: " + animal1 + ", " + animal2);
			}catch(StringIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
			System.out.println();
			
			System.out.println("String to UPPERCASE: " + sampleStr.toUpperCase() + "\n");
			
			System.out.println("String to lowercase: " + sampleStr.toLowerCase());
			
			System.out.println("************************Program Ends*********************");
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		
	}
}
