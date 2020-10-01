package com.hsbc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.model.Product;
import com.hsbc.service.ProductImpl;

/**
 * Servlet implementation class Remove
 */
@WebServlet("/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ProductImpl productImpl;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Remove() {
        super();
        this.productImpl = new ProductImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		Product product = new Product(productId);
		String responseStr = productImpl.removeProduct(product);
		response.setContentType("text/html");
		response.getWriter().println("<h3>" + responseStr + "</h3>");
		
	}

	

}
