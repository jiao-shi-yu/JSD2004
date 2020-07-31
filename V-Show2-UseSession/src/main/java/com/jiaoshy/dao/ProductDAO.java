package com.jiaoshy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jiaoshy.entity.Product;
import com.jiaoshy.util.DBUtils;

public class ProductDAO {
	public void insert(Product product) {
		try (Connection conn = DBUtils.getConnection()) {
			String sql = "INSERT INTO products VALUES(null,?,?,?,?,?,0,0)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getTitle());
			ps.setString(2, product.getAuthor());
			ps.setString(3, product.getIntro());
			ps.setString(4, product.getImgPath());
			ps.setInt(5, product.getCategoryId());
			ps.executeUpdate();
			System.out.println("发布完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Product> findAll() {
		List<Product> productList = new ArrayList<>();
		try (Connection conn = DBUtils.getConnection()) {
			String sql = "SELECT * FROM products";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				String intro = rs.getString(4);
				String imgPath = rs.getString(5);
				int categoryId = rs.getInt(6);
				int viewCount = rs.getInt(7);
				int likeCount = rs.getInt(8);
				Product product = new Product(id, title, author, intro, imgPath, categoryId, viewCount, likeCount);
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	
	public List<Product> findViewList() {
		List<Product> productList = new ArrayList<>();
		try (Connection conn = DBUtils.getConnection()) {
			String sql = "SELECT * FROM products ORDER BY likeCount DESC LIMIT 0, 4";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				String intro = rs.getString(4);
				String imgPath = rs.getString(5);
				int categoryId = rs.getInt(6);
				int viewCount = rs.getInt(7);
				int likeCount = rs.getInt(8);
				Product product = new Product(id, title, author, intro, imgPath, categoryId, viewCount, likeCount);
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;	
	}
	
}
