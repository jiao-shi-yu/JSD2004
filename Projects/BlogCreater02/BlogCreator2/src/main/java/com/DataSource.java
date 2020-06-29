package com;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataSource {
	/**
	 * 最新文章条目数
	 */
	public static final int TOP_15 = 15;
	/**
	 * 文章预览条目
	 */
	public static final int PREVIEW_5 = 5;
	
	// 所有栏目 及 栏目下的文章
	private Map<String, List<Article>> dataSource;
	
	// 所有最新文章
	private List<Article> topArticles = new ArrayList<>();
	// 所有预览文章
	private List<Article> previewArticles = new ArrayList<>();
	
	/**
	 * subjectNames是一个List
	 * 每个元素是一个Map<String, String>
	 * pathName: it
	 * subjectName: 科技
	 */
	private List<Map<String, String>> subjectNames = new ArrayList<>();
	
	
	/**
	 * 构造方法，用来初始化DataSource
	 */
	public DataSource(Map<String, List<Article>> dataSource) {
		// 先用dataSource属性，接收一下
		this.dataSource = dataSource;
		// 1. 初始化最新文章
		initTop15Articles();
		// 2. 初始化预览文章
		initPrevie5Articles();
		// 3. 初始化栏目信息
		initSubjectNames();
		
	}

	private void initTop15Articles() {
		/**
		 * 1. 将所有栏目中的所有文章存入topArticles
		 * 
		 */
		Collection<List<Article>> values = dataSource.values();
		for (List<Article> list: values) {
			topArticles.addAll(list);
		}
		/**
		 * 2. 将所有文章按照最后修改时间进行排序 最新的排后面， 时间倒叙
		 */
		topArticles.sort((article1, article2) -> 
		article1.getLastModified() > article2.getLastModified() ? -1 : 1  
		);
		
		/**
		 * 3. 取最新的15条
		 */
		topArticles = topArticles.subList(0, Integer.min(topArticles.size(), 15));
		System.err.println(topArticles);
	}
	

	private void initPrevie5Articles() {
		previewArticles = topArticles.subList(0, Integer.min(5, topArticles.size()));
	}

	private void initSubjectNames() {
		/**
		 * dataSource中的key包含了栏目路径名和栏目名
		 * 先遍历这个key, 然后字符串分割的到栏目路径和栏目名
		 */
		Set<String> subjects = dataSource.keySet();
		for (String subjectString : subjects) {
			String pathName = subjectString.split("_")[0];
			String subjectName = subjectString.split("_")[1];
			/**
			 * 把这两个值存到Map中
			 */
			Map<String, String> subject = new HashMap<>();
			subject.put("pathName", pathName);
			subject.put("subjectName", subjectName);
			
			/**
			 * subjectNames 添加 map
			 */
			subjectNames.add(subject);
		}
	}

}
