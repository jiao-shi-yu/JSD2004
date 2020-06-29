package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
	
	/**
	 * 定义一些属性
	 */
	// thymeleaf引擎
	private TemplateEngine te;
	/**
	 * 定义一个构造方法，主要用来初始化，thymeleaf引擎
	 */
	public Creator() {
		initTemplateEngine();
		
	}


	private void initTemplateEngine() {
		System.err.println("设置引擎");
		FileTemplateResolver tr = new FileTemplateResolver();
		// 模板解析器设置模板模式
		tr.setTemplateMode("html");
		// 设置字符编码
		tr.setCharacterEncoding("utf-8");
		// 创建模板引擎
		te = new TemplateEngine();
		te.setTemplateResolver(tr);
		System.err.println("完成引擎设置");
	}
	
	
	/**
	 * main方法
	 * @param args
	 */
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
		// 4. 生成栏目信息
		createSubject(ds);
		// 5. 复制图片
		copyResourceFile();
	}
	private void copyResourceFile() {
		// 获取数据源中的栏目目录
		File[] subjectDirs = DataSourceDir.listFiles((f)->f.isDirectory());
		// 遍历
		for (File subjectDir : subjectDirs) {
			// 扫描所有非md文件
			File[] resources = subjectDir.listFiles((f)->f.isFile()&&!f.getName().endsWith(".md"));
			
			// 目标文件夹
			File descDir = new File(WebappDir, subjectDir.getName().split("_")[0]);
			// 遍历文件
			for (File resource : resources) {
				try (
					FileInputStream fis = new FileInputStream(resource);
					FileOutputStream fos = new FileOutputStream(new File(descDir, resource.getName()));
				) {
					byte[] data = new byte[10*1024];
					int len = -1;
					while ((len = fis.read(data))!=-1) {
						fos.write(data, 0, len);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}


	/**
	 * 从数据源中复制图片到 网站目录下
	 */
	
	/**
	 * 生成栏目信息
	 * @param ds
	 */
	/**
	 * @param ds
	 */
	private void createSubject(DataSource ds) {
		/**
		 * 1. 通过调用getDataSource()方法，获得dataSource属性，
		 * 这个属性是一个Map，
		 * key为栏目名，格式为pathName_subjectName
		 * value为栏目下的文章列表。
		 * 
		 * 在WebappDir这个目录下生成，栏目目录，只用到pathName
		 * 
		 * 2. 从list中，获取文章对象，生成 文章页面
		 * 
		 */
//		System.out.println(ds.getDataSource());
//		Set<String> names = ds.getDataSource().keySet();
//		for (String name : names) {
//			String pathName = name.split("_")[0];
//			File subjectDir = new File(WebappDir, pathName);
//			if (!subjectDir.exists()) {
//				subjectDir.mkdir();
//			}
//		}
//		for(Map<String, String> map: ds.getAllSubjectNames()) {
//			String fileName = map.get("pathName");
//			File dir = new File(WebappDir, fileName);
//			if (!dir.exists()) {
//				dir.mkdir();
//			}
//		}
		Set<Entry<String, List<Article>>> entrySet = ds.getDataSource().entrySet();
		
		
		for (Entry<String, List<Article>> entry : entrySet) {
			String fileName = entry.getKey().split("_")[0];
			String subjectName = entry.getKey().split("_")[1];
			File subjectDir = new File(WebappDir, fileName);
			System.err.println(subjectDir);
			if (!subjectDir.exists()) {
				subjectDir.mkdir();
			}
			
			// 生成栏目下的文章
			List<Article> list = entry.getValue();
			for (Article article : list) {
				Context context = new Context();
				context.setVariable("dataSource", ds);
				context.setVariable("article", article);
				
				File articleFile = new File(subjectDir, article.getFileName());
				System.err.println("\t" + articleFile);
				createHtml("./template/category/detail.html", context, articleFile);
			}
			
			// 生成栏目的首页
			Context context = new Context();
			//		栏目名，用于在栏目首页上显示标题。
			context.setVariable("subjectName", subjectName);
			//		上方栏目超链接 和 右侧最新15篇文章
			context.setVariable("dataSource", ds);
			//		当前栏目所有文章 生成文章列表及超链接
			context.setVariable("articles", list);
			File subjectIndex = new File(subjectDir, "index.html");
			createHtml("./template/category/index.html", context, subjectIndex);
		}
		
		
	}
	private void createIndexPage(DataSource ds) {
		/* 使用thymeleaf 将模板页面 中的首页和DataSource 结合
		 * 生成博客首页
		 */

		// Context对象
		Context context = new Context();
		context.setVariable("dataSource", ds);
		
		// 将生成的首页代码写入文件。
		File index = new File(WebappDir, "index.html");
		
		createHtml("./template/index.html", context, index);
		
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
	
	/**
	 * 将上下文变量和模板页面结合，生成ＨＴＭＬ字符串，写入到file对象中。
	 * @param tempPath 模板页面的路径
	 * @param context 上下文变量
	 * @param file 文件对象，输出到这个文件
	 */
	private void createHtml(String tempPath, Context context, File file) {
		String html = te.process(tempPath, context);
		try (FileOutputStream fos = new FileOutputStream(file)) {
			fos.write(html.getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
