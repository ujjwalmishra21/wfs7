package com.hsbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.hsbc.dao.ProductDAO;
import com.hsbc.model.Product;

public class ProductImpl extends DBConnection implements ProductDAO  {
	
	public ProductImpl() {
//		this.intializeDB();
	}
	
	public void intializeDB() {
		PreparedStatement pre = null;
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:C:\\Users\\ujjwa\\testDB;create=true");
			
			con.setAutoCommit(false);
			st = con.createStatement();
			
			st.executeUpdate("Create table products(productId int primary key,productName varchar(50),category varchar(50), price int, quantity int, rol int)");
			Thread.sleep(1000);
	
			System.out.println("Table created");
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			releaseResources(con, st);
			
		}
	}
	
	
	private String updateDB(Product product) {
	
		String updateQuery = "UPDATE PRODUCTS SET productName=(?), category=(?), quantity=(?), price=(?) WHERE productId = (?)";

		PreparedStatement preSt = null;
		Connection con = null;
		try {
			
			con = getConnection();
			
			con.setAutoCommit(false);
		
			preSt = con.prepareStatement(updateQuery);
			preSt.setString(1, product.getProductName());
			preSt.setString(2, product.getCategory());
			preSt.setInt(3, product.getPrice());
			preSt.setInt(4, product.getQuantity());
			preSt.setInt(5, product.getProductId());
			
			
			int recordCount = preSt.executeUpdate();
			if(recordCount > 0) {
				con.commit();
				releaseResources(con, preSt);
				return "Record updated successfully";
				
			}
			releaseResources(con, preSt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return "Record cannot be updated";
	}
	
	
	@Override
	public String addProduct(Product product) {
		Product productGet = getProductById(product);
		if(productGet != null) {
			
			return updateDB(product);
		}
		String insertQuery = "INSERT INTO products(productId, productName, category, price, quantity, rol) VALUES(?,?,?,?,?,?)";

		PreparedStatement preSt = null;
		Connection con = null;
		try {
			
			con = getConnection();
			
			con.setAutoCommit(false);
		
			preSt = con.prepareStatement(insertQuery);
			preSt.setInt(1, product.getProductId());
			preSt.setString(2, product.getProductName());
			preSt.setString(3, product.getCategory());
			preSt.setInt(4, product.getPrice());
			preSt.setInt(5, product.getQuantity());
			preSt.setInt(6, product.getRol());
			
			int recordCount = preSt.executeUpdate();
			if(recordCount > 0) {
				con.commit();
				System.out.println("Record inserted");
				return "Record inserted successfully";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			
			releaseResources(con, preSt);
			
		}
		return "Record cannot be inserted";
	}

	@Override
	public String removeProduct(Product product) {
		
		String deleteQuery = "DELETE FROM products WHERE productId = (?)";

		PreparedStatement preSt = null;
		Connection con = null;
		try {
			
			con = getConnection();
			
			con.setAutoCommit(false);
		
			preSt = con.prepareStatement(deleteQuery);
			preSt.setInt(1, product.getProductId());
			
			
			int recordCount = preSt.executeUpdate();
			if(recordCount > 0) {
				con.commit();
				System.out.println("Record deleted");
				return "Record deleted successfully";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			
			releaseResources(con, preSt);
			
		}
		return "Record cannot be deleted";
	}

	@Override
	public List<Product> getProduct() {

		List<Product> products = new ArrayList<Product>();
		
		try {
			System.out.println("ajlkaslall");
			
			RowSetFactory factory = RowSetProvider.newFactory();
			CachedRowSet crs = factory.createCachedRowSet();
			crs.setUrl("jdbc:derby:C:\\Users\\ujjwa\\testDB");
			crs.setCommand("SELECT * FROM products");
			crs.execute();
			
			
			while(crs.next()) {
				int id = crs.getInt(1);
				String name = crs.getString(2);
				String category = crs.getString(3);
				System.out.println(id + ", " + name + ",");
				int price= crs.getInt(4);
				int quantity = crs.getInt(5);
				int rol = crs.getInt(6);
				Product product = new Product(id, name, category, price, quantity, rol);
				products.add(product);
			
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return products;

		
	}
	
	@Override
	public List<Product> getProductCustom(String database, String username, String password, String query) {

		List<Product> products = new ArrayList<Product>();
		
		try {
			System.out.println("ajlkaslall");
			
			RowSetFactory factory = RowSetProvider.newFactory();
			CachedRowSet crs = factory.createCachedRowSet();
			crs.setUrl(database);
			crs.setCommand(query);
			crs.execute();
			
			
			while(crs.next()) {
				int id = crs.getInt(1);
				String name = crs.getString(2);
				String category = crs.getString(3);
				System.out.println(id + ", " + name + ",");
				int price= crs.getInt(4);
				int quantity = crs.getInt(5);
				int rol = crs.getInt(6);
				Product product = new Product(id, name, category, price, quantity, rol);
				products.add(product);
			
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return products;

		
	}

	
	@Override
	public Product getProductById(Product product) {
		String selectQuery = "SELECT * FROM PRODUCTS WHERE productId = (?)";

	
		
		try {
			System.out.println("ajlkaslall");
			
			RowSetFactory factory = RowSetProvider.newFactory();
			CachedRowSet crs = factory.createCachedRowSet();
			crs.setUrl("jdbc:derby:C:\\Users\\ujjwa\\testDB");
			crs.setCommand(selectQuery);
			crs.execute();
			
			
			while(crs.next()) {
				int id = crs.getInt(1);
				String name = crs.getString(2);
				String category = crs.getString(3);
				System.out.println(id + ", " + name + ",");
				int price= crs.getInt(4);
				int quantity = crs.getInt(5);
				int rol = crs.getInt(6);
				Product productDB = new Product(id, name, category, price, quantity, rol);
				return productDB;
			
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return null;
	}
	
	
}
