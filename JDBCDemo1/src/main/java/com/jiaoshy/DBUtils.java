package com.jiaoshy;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	public static Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
					"root", "yuyu520");
			return conn;
		} catch (Exception exception) {
			
		}
		return null;
	}
}
