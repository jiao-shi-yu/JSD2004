package com.jiaoshy;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

public class Demo2 {
	public static void main(String[] args) throws IOException, SQLException {
		//创建连接池对象
				DruidDataSource ds = new DruidDataSource();
				
				
				//创建读取配置文件的对象
				Properties p = new Properties();
				//通过类加载器获取配置文件输入流
				InputStream ips = DBUtils.class.getClassLoader()
						.getResourceAsStream("jdbc.properties");
				//让对象和输入流关联
				p.load(ips);
				//开始读取数据
				String driver = p.getProperty("db.driver");
				String url = p.getProperty("db.url");
				String name = p.getProperty("db.username");
				String password = p.getProperty("db.password");
				
				//设置数据库连接信息
				ds.setDriverClassName(driver);
				ds.setUrl(url);
				ds.setUsername(name);
				ds.setPassword(password);
				//设置初始连接数量 和最大连接数量
				ds.setInitialSize(3);
				ds.setMaxActive(10);  
				//从连接池中获取连接对象  把异常抛出
				Connection conn = ds.getConnection();
				System.out.println(conn);
				
	}
}
