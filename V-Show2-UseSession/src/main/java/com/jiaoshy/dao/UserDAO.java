package com.jiaoshy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jiaoshy.entity.User;
import com.jiaoshy.util.DBUtils;

public class UserDAO {
	public User findByUsernameAndPassword(String username, String password) {
		try (Connection conn = DBUtils.getConnection()) {
			String sql = "SELECT id FROM user WHERE username=? AND password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				User user = new User(id, username, password);
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
