package com.jiaoshy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 由于是post请求，request设置字符集
		request.setCharacterEncoding("UTF-8");
		// 获取上传文件的信息， pic为上传文件参数名
		Part part = request.getPart("pic");
		String fileName = part.getSubmittedFileName();
		part.write("D:/"+fileName);
		System.out.println("上传完成");
	}

}
