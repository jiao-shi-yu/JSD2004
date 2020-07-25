package com.jiaoshy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import com.jiaoshy.dao.HeroDAO;
import com.jiaoshy.entity.Hero;
import com.jiaoshy.util.ThymeleafUtils;


public class ShowUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HeroDAO heroDAO = new HeroDAO();
		Hero hero = heroDAO.findById(id);
		
		Context context = new Context();
		context.setVariable("hero", hero);
		ThymeleafUtils.print("update.html", context, response);
		
	}

}
