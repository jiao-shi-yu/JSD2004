package com.jiaoshy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jiaoshy.entity.Banner;
import com.jiaoshy.util.DBUtils;

public class BannerDAO {
	public List<Banner> findAll() {
		List<Banner> list = new ArrayList<Banner>();
		try (Connection conn = DBUtils.getConnection()) {
			String sql = "SELECT * FROM banners";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String imgPath = rs.getString(2);
				Banner banner = new Banner(id, imgPath);
				list.add(banner);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
