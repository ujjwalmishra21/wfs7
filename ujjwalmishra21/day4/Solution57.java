package com.hsbc.day4;
/*
 * Program with method which contains return inside finally block
 */
public class Solution57 {

	public static void main(String[] args) {
		
		String str = "I am a Computer Engineer";
		String result = getSubStringPostLengthN(str, 10);
		
		System.out.println("Response: " + result);

	}
	
	@SuppressWarnings("finally")
	public static String getSubStringPostLengthN(String string, int N) {
		
		String substring = "";
		boolean exception = false;
		try {
			substring = string.substring(N);
		}catch(StringIndexOutOfBoundsException e) {
			e.getSuppressed();
			exception = true;
		}finally {
			if(exception)
				return "---------------No string obtained-----------------";
			else
				return substring;
						
		}
	}
}
