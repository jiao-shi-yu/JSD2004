package com.jiaoshy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiaoshy.dao.HeroDAO;
import com.jiaoshy.entity.Hero;

public class AddHeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String heroName = request.getParameter("heroName");
		String heroType = request.getParameter("heroType");
		int heroPrice = Integer.parseInt(request.getParameter("heroPrice"));
		
		Hero hero = new Hero(1, heroName, heroType, heroPrice);
		HeroDAO heroDao = new HeroDAO();
		heroDao.insert(hero);
		
		response.setContentType("text/html;charset=utf-8");
//		response.getWriter().println("插入成功！");
		
		response.sendRedirect("ListHeroesServlet");
		
		
		
	}
	
}
