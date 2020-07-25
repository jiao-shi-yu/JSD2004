package com.jiaoshy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListHeroesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (Connection conn = DBUtils.getConnection()) {
			String sql = "SELECT * FROM heroes";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println("<table border='1' cellspacing=0>");
			pw.println("<tr><th>ID</th><th>姓名</th><th>类型</th><th>价格</th><th>操作</th>");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				int price = rs.getInt(4);
				System.err.println(id + name + type + price);
				
				pw.println("<tr><th>"+id+"</th><th>"+name+"</th><th>"+type+"</th><th>"+price+"</th><th><a href='DeleteServlet?id="+id+"'>删除</a></th>");
			}
			pw.println("</table>");
			pw.println("</table>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
