package com.jiaoshy;

import java.sql.Connection;

public class Demo1 {
	public static void main(String[] args) {
		try (Connection conn = DBUtils.getConn()) {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
