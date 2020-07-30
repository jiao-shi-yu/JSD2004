package com.jiaoshy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import com.jiaoshy.util.ThymeleafUtils;


public class ShowLoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\n\tShowLoginServlet:");
		
		Context context = new Context();
		Cookie[] cookies = request.getCookies();
		
		System.out.println("\t" + cookies);
		if (cookies != null) {
			System.out.println("不等于null");
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					String username = cookie.getValue();
					context.setVariable("username", username);
				}
				if (cookie.getName().equals("password")) {
					String password = cookie.getValue();
					context.setVariable("password", password);
				}
			}
		}

		
		ThymeleafUtils.print("login.html", context, response);

	}

}
