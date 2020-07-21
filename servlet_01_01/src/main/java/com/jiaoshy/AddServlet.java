package com.jiaoshy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double num1 = Integer.parseInt(request.getParameter("num1"));
		double num2 = Integer.parseInt(request.getParameter("num2"));
		double sum = num1 + num2;
		response.getWriter().println("<h1>" + num1 + " + " + num2 + " = " + sum + "</h1>");
	}



}
