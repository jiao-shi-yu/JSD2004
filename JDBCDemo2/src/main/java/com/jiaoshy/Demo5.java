package com.jiaoshy;

import java.sql.Connection;
import java.sql.Statement;
/**
 * Batch
 * @author jiao_
 *
 */
public class Demo5 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Connection conn = DBUtils.getConnection()) {
			String sql1 = "INSERT INTO users VALUES(null, 'aaa', 123)";
			String sql2 = "INSERT INTO users VALUES(null, 'bbb', 123)";
			String sql3 = "INSERT INTO users VALUES(null, 'ccc', 123)";
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql1);
			statement.executeUpdate(sql2);
			statement.executeUpdate(sql3);
			statement.addBatch(sql1);
			statement.addBatch(sql2);
			statement.addBatch(sql3);
			statement.executeBatch();
			System.out.println("执行完成，你去查询看看吧");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
