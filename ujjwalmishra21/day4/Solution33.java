package com.hsbc.day4;

import com.hsbc.day4.house.Hall;
import com.hsbc.day4.house.Kitchen;

public class Solution33 {
	
	public static void main(String args[]) {
		 
		Hall hall = new Hall();
		hall.message();
		Runtime r = Runtime.getRuntime();
		
		String appliances[] = {"Juicer", "Refrigerator", "Washing Machine", "Heater", "Microwave"};
		Kitchen kitchen = new Kitchen(appliances);
		String devices[] = kitchen.getAppliances(appliances);
		
		r.gc();
		
		for(String device : devices) {
			System.out.println(device);
		}
		
		
	}
}
