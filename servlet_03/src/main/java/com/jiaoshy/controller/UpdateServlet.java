package com.jiaoshy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiaoshy.dao.HeroDAO;
import com.jiaoshy.entity.Hero;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		int id = Integer.parseInt(request.getParameter("id"));
		String heroName = request.getParameter("heroName");
		String heroType = request.getParameter("heroType");
		int heroPrice = Integer.parseInt(request.getParameter("heroPrice"));
		
		System.out.println(id + "\t" + heroName + "\t" + heroType + "\t" + heroPrice);
		
		HeroDAO heroDAO = new HeroDAO();
		Hero hero = new Hero(id, heroName, heroType, heroPrice);
		heroDAO.update(hero);
		
		response.setContentType("text/html;charset=UTF-8");
		
		response.sendRedirect("ListHeroesServlet");
	}	
	
}

