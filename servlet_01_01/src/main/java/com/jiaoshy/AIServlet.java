package com.jiaoshy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AIServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");
		message = message.replace("吗", "");
		message = message.replace("我", "我也");
		message = message.replace("？", "!");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(message+"<br/><a href='AI.html'>继续，不要停</a>");
	}


}
