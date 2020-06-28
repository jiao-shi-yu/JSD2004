package com;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.FileTemplateResolver;

public class Creator {
	/**
	 * 数据源目录
	 */
	public static final File DataSourceDir = new File("./datasource");
	/**
	 * 博客网站目录
	 * @param args
	 */
	public static final File WebappDir = new File("./myBlog");
	public static void main(String[] args) {
		Creator creator = new Creator();
		creator.start();
	}
	public void start() {
		// 1. 解析数据源目录，生成DataSource对象
		DataSource ds = loadDataSource();
		// 2. 生成导出博客页面的根目录
		createWebappDir();
		// 3. 生成首页
		createIndexPage(ds);
	}
	private void createIndexPage(DataSource ds) {
		/* 使用thymeleaf 将模板页面 中的首页和DataSource 结合
		 * 生成博客首页
		 */
		FileTemplateResolver tr = new FileTemplateResolver();
		// 模板解析器设置模板模式
		tr.setTemplateMode("html");
		// 设置字符编码
		tr.setCharacterEncoding("utf-8");
		// 创建模板引擎
		TemplateEngine te = new TemplateEngine();
		te.setTemplateResolver(tr);
		
		// Context对象
		Context context = new Context();
		context.setVariable("dataSource", ds);
		String html = te.process("./template/index.html", context);
		// 将生成的首页代码写入文件。
		File indexFile = new File(WebappDir, "index.html");
		try {
			FileOutputStream fos = new FileOutputStream(indexFile);
			fos.write(html.getBytes("utf-8"));
			System.out.println("首页已经生成");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	/**
	 * 生成导出博客页面的根目录
	 */
	private void createWebappDir() {
		
		if (!WebappDir.exists()) {
			WebappDir.mkdirs();
		}
	}
	/**
	 * 读取数据源目录，扫描所有的栏目目录。及对应的.md文件
	 * 并以DataSource对象形式返回。
	 * @return
	 */
	public DataSource loadDataSource() {
		/*
		 * 首先创建一个Map, 
		 * key 是 String, value 是 List<Article> 
		 * 
		 * 然后获取DataSourceDir（源数据目录）中每个子目录
		 * （每个子目录相当与一个栏目），用该目录的名字作为key
		 * 
		 *  然后再获取每个栏目中的所有md文件.
		 *  并将每个md文件转化为一个Article对象并存入List集合.
		 *  再将该集合作为value
		 *  
		 *  最终得到的map中有若干组键值对.
		 *  每一组是一个栏目    
		 *  key为栏目名.
		 *  value为栏目下的所有文章
		 * 	
		 *	Mac OS 
		 *  过滤掉 "_", "."开头的。
		 */
		Map<String, List<Article>> map = new HashMap<>();
		File[] subjects = DataSourceDir.listFiles(f->f.isDirectory());
		for (File subject : subjects) {
			System.out.println(subject.getName());
			File[] articleFiles = subject.listFiles(
					f->f.getName().endsWith(".md")
					&&!f.getName().startsWith(".")
					&&!f.getName().startsWith("_"));
			// 栏目下文章文件，按照时间倒序排列 // 栏目内排了序
			Arrays.sort(articleFiles, (f1, f2) -> f1.lastModified() < f2.lastModified() ? -1 : 1);
			List<Article> articleList = new ArrayList<>();
			// 遍历每一个文章文件
			for (File articleFile : articleFiles) {
				Article article = new Article(articleFile);
				articleList.add(article);
			}
		
			map.put(subject.getName(), articleList);
		}
		return new DataSource(map);
	}
	
}
