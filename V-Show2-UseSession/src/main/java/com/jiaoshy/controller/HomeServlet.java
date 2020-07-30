package com.jiaoshy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.Context;

import com.jiaoshy.dao.BannerDAO;
import com.jiaoshy.dao.CategoryDAO;
import com.jiaoshy.entity.Banner;
import com.jiaoshy.entity.Category;
import com.jiaoshy.entity.User;
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
		
		List<Category> categoryList = dao.findAll();
		System.out.println(categoryList);
		context.setVariable("categoryList", categoryList);
		
		
		// 从Session中获取user对象
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		context.setVariable("user", user);
		
		// 使用BannerDAO查询Banner，并使用context设置变量
		BannerDAO bannerDAO = new BannerDAO();
		List<Banner> banners = bannerDAO.findAll();
		context.setVariable("banners", banners);
		
		ThymeleafUtils.print("home.html", context, response);
	}

	

}
