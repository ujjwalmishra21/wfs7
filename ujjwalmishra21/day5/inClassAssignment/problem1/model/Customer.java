package com.hsbc.day5.problem1.model;

import java.util.List;
import java.io.Serializable;

public class Customer implements Comparable<Customer>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Address address;
	private List<Product> product;
	private int totalPrice;
	
	
	public Customer() {
		super();
	}
	public Customer(String name, Address address, List<Product> product) {
		super();
		this.name = name;
		this.address = address;
		this.product = product;
		for(Product prod : product) {
			this.totalPrice += prod.getPrice();
		}
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", product=" + product + ", totalPrice=" + totalPrice
				+ "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	@Override
	public int compareTo(Customer o) {
		return o.getTotalPrice() - this.getTotalPrice();
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
