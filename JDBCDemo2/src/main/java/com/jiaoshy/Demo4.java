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

		try (Connection conn = DBUtils.getConnection();) {
			//Statement s = conn.createStatement();
			//String sql = "select count(*) from user where username='"+username+"'and password='"+password+"'";
			//ResultSet rs = s.executeQuery(sql);
			//******* 通过预编译SQL执行对象解决SQL注入问题 *******
			String sql = "select count(*) from users where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			//编译时间点由原来的执行时提前到创建SQL执行对象时,在执行时将SQL语句逻辑锁死,不受用户输入影响
			//替换SQL语句的? 1和2代表的是?的位置
			ps.setString(1, username);
			ps.setString(2, password);
			//执行SQL语句
			ResultSet rs =ps.executeQuery();
			
			//此时结果集中肯定会有一条数据
			rs.next();
			//取出结果集中返回的统计数量 这个1代表的是获取返回的唯一一条数据
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
