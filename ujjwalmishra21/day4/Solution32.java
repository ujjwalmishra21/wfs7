package com.hsbc.day4;

import java.util.Scanner;
/*
 * Program showing usage of Scanner  class to take  user input
 */
public class Solution32 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter your name:");
		String name = sc.next();
		System.out.println();
		
		System.out.println("Enter your degree (SSC/ HSC/ BCom/ BSc/ BA/ MCom/ MSc/ BTech/ MTech/ Other):");
		String degree = sc.next();
		System.out.println();
		
		System.out.println("Enter age: ");
		int age = sc.nextInt();
		System.out.println();
		
		System.out.println("Enter total obtained marks: ");
		double obtainedMarks = sc.nextDouble();
		System.out.println();
		
		System.out.println("Enter total marks:");
		double totalMarks = sc.nextDouble();
				
		try {
			Student student = new Student(name, degree, age, obtainedMarks, totalMarks);
			System.out.println(student);
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}

class Student{
	private String name;
	private Degree degree;
	private int age;
	private double obtainedMarks;
	private double totalMarks;
	private double percentage;
	
	public Student(String name, String degree, int age, double obtainedMarks, double totalMarks) {
		super();
		this.name = name;
		this.degree = Degree.valueOf(degree);
		this.age = age;
		this.obtainedMarks = obtainedMarks;
		this.totalMarks = totalMarks;
		this.percentage = (this.obtainedMarks / this.totalMarks) * 100;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", degree=" + degree + ", age=" + age + ", marks=" + obtainedMarks
				+ "/" + totalMarks + ", percentage=" + percentage + "]";
	}
}

enum Degree{
	SSC, 
	HSC,
	BCom,
	BSc,
	BA,
	MCom,
	MSc,
	BTech,
	MTech,
	Other
}
