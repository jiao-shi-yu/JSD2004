package com.jiaoshy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo7 {
	public static void main(String[] args) {
		try (Connection conn = DBUtils.getConnection()) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入第几页");
			int page = scanner.nextInt();
			System.out.println("请输入每页显示几行");
			int count = scanner.nextInt();
			
			String sql = "SELECT * FROM users LIMIT ?, ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, (page-1)*count);
			ps.setInt(2, count);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				System.out.println(id + "\t" + username + "\t" + password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
