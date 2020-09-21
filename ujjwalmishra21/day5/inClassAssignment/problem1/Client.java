package com.hsbc.day5.problem1;

import java.util.List;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

import com.hsbc.day5.problem1.model.Address;
import com.hsbc.day5.problem1.model.Customer;
import com.hsbc.day5.problem1.model.Product;
import com.hsbc.day5.problem1.services.CustomerImpl;

public class Client {

	public static void main(String[] args) throws IOException {
		
		CustomerImpl impl = new CustomerImpl();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			
			System.out.println("Enter your name:");
			String name = br.readLine().trim();
			
			System.out.println("Enter you city:");
			String city = br.readLine().trim();
			
			System.out.println("Enter your state:");
			String state = br.readLine().trim();
			List<Product> list = new ArrayList<Product>();
			
			while(true) {
				System.out.println("Enter product name:");
				String pName = br.readLine().trim();
				
				System.out.println("Enter product price:");
				int price = Integer.parseInt(br.readLine().trim());
				Product product = new Product(pName, price);
				list.add(product);
				
				System.out.println("Enter Y to add more products or N to exit:");
				String next = br.readLine().trim();
				
				if(next.toLowerCase().equals("n")) {
					break;
				}
			}
			
			Address address = new Address(city, state);
						
			Customer customer = new Customer(name, address, list);
			
			
			impl.addCustomer(customer);
			
			System.out.println("Enter Y to add more customer or N to exit:");
			String next = br.readLine().trim();
			
			if(next.toLowerCase().equals("n")) {
				break;
			}
			
		}
		
		
		impl.sortCustomer();
		impl.addToFile();
		
		System.out.println("List Data:");
		System.out.println(impl.getCustomers());
		System.out.println();
		
		
	
		impl.getFromFile();
		
		br.close();

	}

}
