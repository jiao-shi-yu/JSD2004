package com.jiaoshy.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

public class DBUtils {
	private static DruidDataSource druidDataSource;
	
	static {
		Properties properties = new Properties();
		InputStream inputStream = DBUtils.class.getClassLoader().
				getResourceAsStream("jdbc.properties");
		
		try {
			properties.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String driver = properties.getProperty("db.driver");
		String jdbcUrl = properties.getProperty("db.url");
		String username = properties.getProperty("db.username");
		String password = properties.getProperty("db.password");
		String maxActive = properties.getProperty("db.maxActive");
		String initialSize = properties.getProperty("db.initialSize");
		
		druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(driver);
		druidDataSource.setUrl(jdbcUrl);
		druidDataSource.setUsername(username);
		druidDataSource.setPassword(password);
		druidDataSource.setMaxActive(Integer.parseInt(maxActive));
		druidDataSource.setInitialSize(Integer.parseInt(initialSize));
		
		
	}
	public static Connection getConnection() throws SQLException{
		return druidDataSource.getConnection();
	}
	
}
