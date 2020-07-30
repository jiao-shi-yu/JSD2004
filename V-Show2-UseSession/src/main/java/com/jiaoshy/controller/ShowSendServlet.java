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
 * Servlet implementation class ShowSendServlet
 */
public class ShowSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Context context = new Context();
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Category> categories = categoryDAO.findAll();
		context.setVariable("categories", categories);
		ThymeleafUtils.print("send.html", context, response);
	}

	

}
