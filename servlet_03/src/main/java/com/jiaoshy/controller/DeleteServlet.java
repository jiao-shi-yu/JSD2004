package com.jiaoshy.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiaoshy.dao.HeroDAO;
import com.jiaoshy.util.DBUtils;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (Connection conn = DBUtils.getConnection()) {
			int id = Integer.parseInt(request.getParameter("id"));
			HeroDAO heroDao = new HeroDAO();
			heroDao.deleteByID(id);
			
			response.sendRedirect("ListHeroesServlet");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
