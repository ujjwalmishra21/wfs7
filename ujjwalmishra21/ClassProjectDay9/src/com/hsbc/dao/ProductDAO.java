package com.hsbc.dao;

import java.util.List;

import com.hsbc.model.Product;

public interface ProductDAO {
	public String addProduct(Product product);
	public String removeProduct(Product product);
	public List<Product> getProduct();
	public Product getProductById(Product product);
	public List<Product> getProductCustom(String database, String username, String password, String query);
	
}
