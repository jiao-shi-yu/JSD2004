package com.jiaoshy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名");
		String username = sc.nextLine();
		System.out.println("请输入密码");
		String password = sc.nextLine();
		sc.close();
		try (Connection conn = DBUtils.getConnection();) {
			
			String sql = "select count(*) from users where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs =ps.executeQuery();
			
			
			rs.next();
			
			int count = rs.getInt(1);
			if(count>0) {
				System.out.println("登录成功");
			}else {
				System.out.println("登录失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
