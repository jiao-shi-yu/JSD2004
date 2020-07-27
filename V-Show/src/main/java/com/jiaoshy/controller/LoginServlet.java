package com.jiaoshy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiaoshy.dao.UserDAO;
import com.jiaoshy.entity.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符编码
		request.setCharacterEncoding("utf-8");
		
		// 获取参数
		String username = request.getParameter("name");
		String password = request.getParameter("pwd");
		System.err.println(username + "\t" + password);
		
		// UserDao从数据库中查询数据
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findByUsernameAndPassword(username, password);
		
		// 业务判断
		if (user==null) {
			// 登陆失败，重新登录
			response.sendRedirect(request.getContextPath() + "/ShowLoginServlet");
		} else {
			// 登陆成功，重定向到首页
			response.sendRedirect(request.getContextPath() + "/HomeServlet");
		}
		
		
		
	}

}
