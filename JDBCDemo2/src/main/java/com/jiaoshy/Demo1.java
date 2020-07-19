package com.jiaoshy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo1 {
	public static void main(String[] args) {
		try (Connection conn = DBUtils.getConnection()) {
			Statement statement = conn.createStatement();
			String sql = "SELECT ename FROM emp";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String name = resultSet.getString(1);
				System.out.println(name);
			}
		} catch (Exception e) {

		}
	}
}
