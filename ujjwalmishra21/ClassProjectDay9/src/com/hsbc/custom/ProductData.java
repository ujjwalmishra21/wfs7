package com.hsbc.custom;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.hsbc.model.Product;
import com.hsbc.service.ProductImpl;

public class ProductData extends BodyTagSupport{
	
	String query;
	String database;
	String username;
	String password;
	
	
	
	
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int doStartTag() throws JspException {
		ProductImpl productImpl = new ProductImpl();
		
		List<Product> list = productImpl.getProductCustom(database, username, password, query);
		
		JspWriter jsp = pageContext.getOut();
		try {
			jsp.print("<table border=1>");
			jsp.print("<tr>");
			jsp.print("<th>Product</th>" );
			jsp.print("<th>Product Name</th>" );
			jsp.print("<th>Product Category</th>" );
			jsp.print("<th>Price</th>" );
			jsp.print("<th>Quantity</th>" );
			jsp.print("<th>ROI</th>" );
			jsp.print("</tr>");
			for(Product product : list) {
				jsp.print("<tr>");
				jsp.print("<td>" + product.getProductId() + "</td>" );
				jsp.print("<td>" + product.getProductName() + "</td>" );
				jsp.print("<td>" + product.getCategory() + "</td>" );
				jsp.print("<td>" + product.getPrice() + "</td>" );
				jsp.print("<td>" + product.getQuantity() + "</td>" );
				jsp.print("<td>" + product.getRol() + "</td>" );
				jsp.print("</tr>");			
			}
				
			jsp.print("</table>");
		}catch (IOException e) {
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		return SKIP_BODY;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}
	
	
}
