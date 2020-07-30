package com.jiaoshy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiaoshy.dao.UserDAO;
import com.jiaoshy.entity.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet:");
		// 设置字符编码
		request.setCharacterEncoding("utf-8");
		
		// 获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.err.println(username + "\t" + password);
		
		// UserDao从数据库中查询数据
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findByUsernameAndPassword(username, password);
		System.out.println(user);
		// 业务判断
		if (user==null) {
			// 登陆失败，重新登录
			response.sendRedirect(request.getContextPath() + "/ShowLoginServlet");
		} else {
			// 登陆成功
			// 获得HttpSession
			HttpSession session = request.getSession();
			System.out.println(session.getId());
			// 把登录成功的对象保存到session中。
			session.setAttribute("user", user);
			
			
			// 是否记住
			String remember = request.getParameter("remember");
			System.out.println("\t" + remember);
			if (remember!=null) {
				
				// 使用Cookie保存用户名密码
				System.out.println("使用Cookie");
				Cookie cookie1 = new Cookie("username", username);
				Cookie cookie2 = new Cookie("password", password);
				
				cookie1.setMaxAge(30*24*60*60);
				
				response.addCookie(cookie1);
				response.addCookie(cookie2);
								
				
			}
			
			// 登陆成功，重定向到首页
			response.sendRedirect(request.getContextPath() + "/HomeServlet");
						
		}
		
		
		
	}

}
