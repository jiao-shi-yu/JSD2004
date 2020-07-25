package com.jiaoshy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig // 上传文件
@WebServlet(name = "UploadServlet", urlPatterns = { "/upload.do" })
public class UploadServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 由于是post请求，request设置字符集
		request.setCharacterEncoding("UTF-8");
		// 获取上传的文件对象的信息， pic为上传文件参数名
		Part part = request.getPart("picture");

		String fileName = getFileName(part);

		part.write("C:/apache-tomcat-8.5.45/webapps/imgs/"+fileName);

		/// -----> 响应部分
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("OK!<br><img src='http://localhost:8080/imgs/"+fileName+"'>");

	}

	private String getFileName(Part part) {
		String header = part.getHeader("Content-Disposition");
		System.out.println("\n\t" + header);

		String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
		System.out.println("[fileName]: " + fileName);

		fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
		System.out.println("[fileName]: " + fileName);
		return fileName;
	}

}
