package com;

import java.io.File;
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
		// 1. 解析数据源目录，生成DataSource对象
		DataSource ds = loadDataSource();
		// 2. 生成WebappDir
		createWebappDir();
		// 3. 使用数据源，还有Thymeleaf框架，生成首页
		createIndexPage(ds);
	}

	
	private void createIndexPage(DataSource ds) {
		/**
		 * 使用Thymeleaf，将首页模板页面和DataSource结合，生成一个静态的博客首页
		 */
		// 1. 先把模板解析器和模板引擎，创建和设置好
		FileTemplateResolver resolver = new FileTemplateResolver();
		resolver.setTemplateMode("html");
		resolver.setCharacterEncoding("utf-8");
		TemplateEngine te = new TemplateEngine();
		te.setTemplateResolver(resolver);
		
		// 2. 准备一个Context上下文对象，用来储存数据。
		Context context = new Context();
		context.setVariable("dataSource", ds);
	}
	

	private void createWebappDir() {
		if (!WebappDir.exists()) {
			WebappDir.mkdir();
		}
	}

	private DataSource loadDataSource() {
		/**
		 * 首先创建一个Map
		 * key是String value是List<Article>
		 * 然后获取dataSourceDir元数据目录下子目录
		 * （每个子目录相当于一个栏目）
		 * 用目录的名字作为key
		 * 
		 * 然后获取每个栏目下的所有.md文件
		 * 利用.md文件生成Article对象 存入List集合
		 * 
		 * 再将该集合作为value
		 * 
		 * 将key， value put到dataSource集合中
		 * 
		 * 这样就生成了一个数据源
		 * 最后返回数据源
		 */
		Map<String, List<Article>> map = new HashMap<>();
		// 获取各个栏目
		File[] subjects = DataSourceDir.listFiles(f -> f.isDirectory());
		for (File subject : subjects) {
			// 获取栏目下的.md文件
			File[] mdFiles = subject.listFiles(f -> 
				f.getName().endsWith(".md")
				&&!f.getName().startsWith(".")
				&&!f.getName().startsWith("_"));
			
			// 栏目下的文件，也按照一个时间倒叙排序
			Arrays.sort(mdFiles,
				(f1, f2) -> 
			f1.lastModified() > f2.lastModified() ? -1 : 1);
			List<Article> articleList = new ArrayList<>(); // 定义一个文章列表
			// 遍历每一个.md文件
			for (File mdFile : mdFiles) {
				// 通过mdFile new 出一篇文章来
				Article article = new Article(mdFile);
				articleList.add(article);
			}
			map.put(subject.getName(), articleList);
		}
		return new DataSource(map);
	}
}
