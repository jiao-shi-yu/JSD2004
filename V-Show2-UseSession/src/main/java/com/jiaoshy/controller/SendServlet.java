package com.jiaoshy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class SendServlet
 */
public class SendServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 必须 设置字符集
		request.setCharacterEncoding("UTF-8");
		// 获取参数
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String intro = request.getParameter("intro");
		String categoryId = request.getParameter("categoryId");
		
		System.out.println(title);
		System.out.println(author);
		System.out.println(intro);
		System.out.println(categoryId);
		Part part = request.getPart("file");
		System.err.println("\n\n\t"+part);

		String header = part.getHeader("Content-Disposition");
		System.out.println(header);
	}

}
