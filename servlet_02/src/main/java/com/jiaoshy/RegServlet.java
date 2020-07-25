package com.jiaoshy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		// 通过获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		// 通过conn对象建立连接
		try (Connection conn = DBUtils.getConnection()) {
			// 先判断是否已经存在
			
			String sql = "SELECT id FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			String responseMessage = null;
			if (rs.next()) {
				// 用户存在
				responseMessage = "用户名已经存在";
			} else {
				responseMessage = "注册成功！";
				sql = "INSERT INTO users VALUES(null, ?, ?)";
				PreparedStatement ps2 = conn.prepareStatement(sql);
				ps2.setString(1, username);
				ps2.setString(2, password);
				ps2.executeUpdate();
			}
			
			// 3. response 对象，设置响应类型，获取输输出流，做出响应
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println(responseMessage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
