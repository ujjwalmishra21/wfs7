package com.hsbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.model.Product;
import com.hsbc.service.ProductImpl;

/**
 * Servlet implementation class Products
 */
@WebServlet("/Products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ProductImpl productImpl;
    public Products() {
        super();
        // TODO Auto-generated constructor stub
        productImpl = new ProductImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		String category = request.getParameter("category");
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int rol = Integer.parseInt(request.getParameter("roi"));
		System.out.println("[" + productId + ", " + productName + ", " + category + ", " + price + ", " + quantity + ", " + rol + "]");
			
		
		
		
		Product product = new Product(productId, productName, category, price, quantity, rol);
		
		productImpl.addProduct(product);
		
		response.getWriter().println("DONE");
			
//		return response.sendRedirect("");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
