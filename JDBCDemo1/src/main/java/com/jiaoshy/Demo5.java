package com.jiaoshy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo5 {
	public static void main(String[] args) {
		
		
		try (Connection conn = DBUtils.getConn();) {
			// 获取连接
			Statement s = conn.createStatement();
			String sql = "SELECT ename, sal FROM emp";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString(1);
				double sal = rs.getDouble(2);
				System.out.println(name + "\t" + sal);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
