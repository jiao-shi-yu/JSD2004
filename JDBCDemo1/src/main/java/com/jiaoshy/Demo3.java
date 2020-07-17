package com.jiaoshy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class Demo3 {
	Connection conn;
	Statement statement;
	// 单元测试
	@Before
	public void getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
					"root", "yuyu520");
			System.out.println(conn);
			statement = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Ignore
	public void insert() {
		String sql = "INSERT INTO emp(empno, ename) values(102, '小明')";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("insert");
	}
	@Ignore
	public void delete() {
	
		String sql = "DELETE FROM emp WHERE empno=102";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("delete");
	}
	@Ignore
	public void update() {
		
		String sql = "UPDATE emp SET ename = 'Jerry' WHERE empno=102";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("update");
	}
	@Test
	public void select() {
		System.out.println("select");
		String sql = "SELECT * FROM emp";
		try {
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("ename");
				double salary = rs.getDouble("sal");
				String job = rs.getString("job");
				System.out.println(name + "\t" + salary + "\t" + job);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@After
	public void close() {
		try {
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
