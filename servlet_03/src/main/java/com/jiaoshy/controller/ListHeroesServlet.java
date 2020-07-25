package com.jiaoshy.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import com.jiaoshy.dao.HeroDAO;
import com.jiaoshy.entity.Hero;
import com.jiaoshy.util.DBUtils;
import com.jiaoshy.util.ThymeleafUtils;

public class ListHeroesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (Connection conn = DBUtils.getConnection()) {
			HeroDAO heroDAO = new HeroDAO();
			List<Hero> list = heroDAO.findAll();
			Context context = new Context();
			context.setVariable("list", list);
			ThymeleafUtils.print("list.html", context, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
