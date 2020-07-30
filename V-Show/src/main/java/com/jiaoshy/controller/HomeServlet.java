package com.jiaoshy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import com.jiaoshy.dao.CategoryDAO;
import com.jiaoshy.entity.Category;
import com.jiaoshy.util.ThymeleafUtils;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeServlet:\n");
		Context context = new Context();
		CategoryDAO dao = new CategoryDAO();
		
		List<Category> list = dao.findAll();
		System.out.println(list);
		context.setVariable("categoryList", list);
		ThymeleafUtils.print("home.html", context, response);
	}

	

}
