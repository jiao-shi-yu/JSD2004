package com.jiaoshy.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class SendServlet
 */
@MultipartConfig
public class SendServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 必须 设置字符集
		request.setCharacterEncoding("UTF-8");
		// 获取参数
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String intro = request.getParameter("intro");
		String categoryId = request.getParameter("categoryId");
		
		System.out.println(title);
		System.out.println(author);
		System.out.println(intro);
		System.out.println(categoryId);
		Part part = request.getPart("file");
		System.err.println("\n\n\tPart: "+part);

		String header = part.getHeader("Content-Disposition");
		System.out.println(header);
		String suffix = header.substring(header.lastIndexOf("."), header.length()-1);
		String fileName = UUID.randomUUID() + suffix;
		System.out.println("\n\n\t" + fileName);
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		String dir = sdf.format(new Date());
		
		File directory = new File("D:/Java/apache-tomcat-8.5.45/webapps/imgs"+dir);
		System.out.println("\n\n\tdirectory: " + directory);
		if (!directory.exists()) {
			System.err.println("\n\n\t路径不存在");
			directory.mkdirs();
			System.err.println("\t路径创建成功");
		}
		System.out.println(directory);
		part.write(dir+fileName);
		System.out.println("dir: " + dir); 
		System.out.println("fileName: " + fileName); 
		
		String url = "http://localhost:8080"
	}

}
