package com.hsbc.day4;
/*
 * Matrix addition program with Exception Handling
 */
public class Solution53 {
	public static void main(String[] args) {
		int array1[][] = new int[][] {{2,1,5},{4,3,5},{8,4,6}};
		
		if(array1.length != array1[0].length)
			System.out.println("Only square matrix can be squared");
		else {
			
			System.out.println("Original Array:");
			try {
				display(array1);
			}catch(ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
			
			System.out.println();
			int mult[][] = null;
			
			try {
				mult = matrixSquare(array1);
			}catch(ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
			
			try {
				System.out.println("Matrix After Square:");
			
				display(mult);
			}catch(ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static int[][] matrixSquare(int arr[][]) throws ArrayIndexOutOfBoundsException, NullPointerException {
		int square[][] = new int[arr.length][arr.length];
		
		for(int i=0;i<arr.length; i++) {
			for(int j=0;j<arr.length; j++) {
				int sum = 0;
				for(int k=0;k<arr.length; k++) {
					sum += arr[i][k] * arr[k][j];
				}
				square[i][j] = sum;
			}
		}
		return square;
	}
	
	public static void display(int arr[][]) throws ArrayIndexOutOfBoundsException, NullPointerException {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) 
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
}
