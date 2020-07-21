package com.jiaoshy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MethodServlet
 */
public class MethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * 请求方式是GET时
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET请求方式的请求");
		String info = request.getParameter("info");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(info);
	}

	/**
	 * 请求方式时POST时
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST请求方式");
		request.setCharacterEncoding("utf-8");
		String info = request.getParameter("info");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(info);
	}

}
