package com.hsbc.day4.house;

public class Kitchen {
	private String[] appliances;
	
	public Kitchen(String appliances[]) {
		this.appliances = appliances;
	}
	
	public String[] getAppliances(String[] appliances) {
		return this.appliances;
	}
	
	@Override
	public void finalize() {
		System.out.println("Finalize called on Kitchen class");
	}
}
