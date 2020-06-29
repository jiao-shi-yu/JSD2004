package com;

import java.io.File;

public class Creator {
	
	/**
	 * 声明一个数据源
	 */
	public static final File DataSourceDir = new File("./dataSource");
	/**
	 * 博客网站目录
	 */
	public static final File WebappDir = new File("./myBlog");
	
	public static void main(String[] args) {
		Creator creator = new Creator();
		creator.start();
	}

	private void start() {
		// 解析数据源目录，生成DataSource对象
		
	}
}
