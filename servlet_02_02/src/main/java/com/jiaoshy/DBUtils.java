package com.jiaoshy;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

public class DBUtils {
	private static DruidDataSource dataSource;
	
	static {
		// 创建Properties对象
		Properties properties = new Properties();
		// 通过类加载器，得到资源输入流
		InputStream ips = 
			DBUtils.class.getClassLoader()
			.getResourceAsStream("jdbc.properties");
		
		try {
			// Properties对象载入流，准备从一个流中读取属性。
			properties.load(ips);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 开始从流中读取属性
		String driverClass = properties.getProperty("db.driver");
		String jdbcUrl = properties.getProperty("db.url");
		String name = properties.getProperty("db.username");
		String password = properties.getProperty("db.password");
		String maxActive = properties.getProperty("db.maxActive");
		String initialSize = properties.getProperty("db.initialSize");
		System.out.println(
				driverClass + "\n" +
				jdbcUrl + "\n" +
				name + "\n" +
				password + "\n" +
				maxActive + "\n" +
				initialSize + "\n" );
		dataSource = new DruidDataSource();
		
		// 设置属性
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(name);
		dataSource.setPassword(password);
		dataSource.setMaxActive(Integer.parseInt(maxActive));
		dataSource.setInitialSize(Integer.parseInt(initialSize));
		
	}
	
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
