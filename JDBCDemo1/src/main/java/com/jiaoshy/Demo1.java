package com.jiaoshy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		// 1. 注册驱动，获取连接
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
				"root", "yuyu520");
		System.out.println(conn);
		// 2. 创建statement对象 执行SQL语句
		Statement s= conn.createStatement();
	
		String sql = "CREATE TABLE jdbct1(id INT, name VARCHAR(10))";
		s.execute(sql);

		// 4. 关闭资源
		s.close();
		conn.close();
		
	}
}
