package com.jiaoshy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BMIServlet
 */
public class BMIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double height = Double.parseDouble(request.getParameter("height"));
		double weight = Double.parseDouble(request.getParameter("weight"));
		
		double bmi = weight / (height * height);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (bmi<18.5) {
			pw.println("兄弟你瘦了");
		} else if (bmi<24) {
			pw.println("岁月静好");
		} else if (bmi<28){
			pw.println("偏胖");
		} else {
			pw.println("超重");
		}
	}

}
