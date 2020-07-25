package com.jiaoshy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jiaoshy.entity.Hero;
import com.jiaoshy.util.DBUtils;

public class HeroDAO {
	public void deleteByID(int id) {
		try (Connection conn = DBUtils.getConnection()) {
			String sql = "DELETE FROM heroes WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected>0) {
				System.out.println("删除成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Hero hero) {
		try (Connection conn = DBUtils.getConnection()) {
			String sql = "INSERT INTO heroes VALUES(null, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, hero.getHeroName());
			ps.setString(2, hero.getHeroType());
			ps.setInt(3, hero.getHeroPrice());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public List<Hero> findAll() {
		ArrayList<Hero> heroes = new ArrayList<>();
		try (Connection conn = DBUtils.getConnection()) {
			String sql = "SELECT * FROM heroes";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String heroName = rs.getString(2);
				String heroType = rs.getString(3);
				int heroPrice = rs.getInt(4);
				Hero hero = new Hero(id, heroName, heroType, heroPrice);
				heroes.add(hero);
			}
			
			return heroes;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(Hero hero) {
		try (Connection conn = DBUtils.getConnection()) {
			int id = hero.getId();
			String sql = "UPDATE heroes SET name=?, type=?, price=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, hero.getHeroName());
			ps.setString(2, hero.getHeroType());
			ps.setInt(3, hero.getHeroPrice());
			ps.setInt(4, hero.getId());
			
			ps.executeUpdate();
			System.out.println("修改完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Hero findById(int id) {
		Hero hero = null;
		try (Connection conn = DBUtils.getConnection()) {
			String sql = "SELECT * FROM heroes WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) { // 判断是否查询到了数据，一次就行
				String heroName = rs.getString(2);
				String heroType = rs.getString(3);
				int heroPrice = rs.getInt(4);
				hero = new Hero(id, heroName, heroType, heroPrice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hero;
	}
}
