package com.hsbc.day5.problem1.services;

import java.util.List;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import com.hsbc.day5.problem1.model.Customer;

public class CustomerImpl {
	private List<Customer> list = new ArrayList<>();
	
	private ObjectOutputStream obj;
	private ObjectInputStream oi;
	
	public void addCustomer(Customer data) {	
		list.add(data);
	}
	
	public void sortCustomer() {
		Collections.sort(list);
	}
	
	public List<Customer> getCustomers(){
		return list;
	}
	
	public void addToFile() throws FileNotFoundException, IOException {
		
		obj = new ObjectOutputStream(new FileOutputStream("customer.txt", true));
		
		for(Customer customer : list) {
			obj.writeObject(customer);
		}
		obj.close();
	}
	
	public void getFromFile()  {
		try {
			oi = new ObjectInputStream(new FileInputStream("customer.txt"));
					
			Customer c = (Customer)oi.readObject();
			if(c != null) {
				System.out.println(c);
				
				while(c!=null) {
					c = (Customer)oi.readObject();
					if(c == null)
						break;
					System.out.println(c);
				}
			}		
			oi.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(EOFException e) {
//			e.printStackTrace();
		}catch(StreamCorruptedException e) {
//			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
}
