package com.jiaoshy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 通过获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		// 通过conn对象建立连接
		try (Connection conn = DBUtils.getConnection()) {
			String responseMessage = null;
			String sql = "SELECT password FROM users WHERE username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String passwordFromDB = rs.getString(1);
				if (password.equals(passwordFromDB)) {
					responseMessage = "登陆成功";
				} else {
					responseMessage = "密码错误";
				}
			} else {
				responseMessage = "登陆失败，用户名不存在";
			}
			// 3. response 对象，设置响应类型，获取输输出流，做出响应
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println(responseMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


