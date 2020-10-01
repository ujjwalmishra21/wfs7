package com.hsbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.model.Product;
import com.hsbc.service.ProductImpl;

/**
 * Servlet implementation class GetProducts
 */
@WebServlet("/GetProducts")
public class GetProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	ProductImpl productImpl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProducts() {
        super();
        productImpl = new ProductImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Product> products = productImpl.getProduct();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("Products------------------" + products);
		for(Product product: products) {
		
			out.println("<h3>" + product.getProductId() + "--" + product.getProductName()  + "</h3");
			out.println("<p> Category: " + product.getCategory()+ "</p>");
			out.println("<p> Price: " + product.getPrice()+ "</p>");
			out.println("<p> Quantity: " + product.getQuantity() + "</p>");
			out.println("<p> ROI: " + product.getRol() + "</p>");
			out.println("***************************************************************************");
			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
