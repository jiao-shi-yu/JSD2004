package com.jiaoshy;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Demo3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名");
		String username = sc.nextLine();
		System.out.println("请输入密码");
		String password = sc.nextLine();
		
		//获取连接对象
		try (Connection conn = DBUtils.getConnection();) {
			Statement s = conn.createStatement();
			String sql = "insert into user values(null,'"+username+"','"+password+"')";
			s.executeUpdate(sql);
			System.out.println("注册成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
