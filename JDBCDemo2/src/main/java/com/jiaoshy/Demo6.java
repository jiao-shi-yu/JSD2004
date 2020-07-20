package com.jiaoshy;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Demo6 {
	public static void main(String[] args) {
		try (Connection conn = DBUtils.getConnection()) {
			String sql = "INSERT INTO users value(null, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 1; i <= 100; i++) {
				ps.setString(1, "name"+i);
				ps.setString(2, "password" + i);
				ps.addBatch();
				if (i%20==0) {
					ps.executeBatch();
				}
			}
			ps.executeBatch();
			System.out.println("批处理 批量插入完成，你去查询看看吧");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
