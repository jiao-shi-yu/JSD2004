package com.jiaoshy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jiaoshy.entity.Category;
import com.jiaoshy.util.DBUtils;

public class CategoryDAO {
	public List<Category> findAll() {
		List<Category> list = new ArrayList<>();
		try (Connection conn = DBUtils.getConnection()) {
			String sql = "SELECT * FROM categories";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				list.add(new Category(id, name));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
