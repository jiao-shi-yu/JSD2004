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
	 * 文章预览条目数
	 */
	public static final int INDEX_PAGE_TOP_5 = 5;
	
	// 所有栏目及对应的文章对象
	private Map<String, List<Article>> dataSource;
	
	// 网站右侧的最新文章
	private List<Article> topArticles = new ArrayList<>();;
	// 网站首页上的预览文章
	private List<Article> indexPageTopArticles = new ArrayList<>();
	
	// 生成栏目超链接
	/**
	 * 每个页面的上方，都有栏目的超链接
	 * 下面集合，每个Map对应到一个栏目
	 * pathName: it
	 * subjectName: 科技
	 */
	private List<Map<String, String>> allSubjectNames 
	= new ArrayList<>();
	
	// 构造方法，用于初始化DataSource
	public DataSource(Map<String, List<Article>> dataSource) {
		this.dataSource = dataSource;
		// 初始化最新15篇文章
		initTop15Articles();
		// 初始化首页最新预览文章
		initIndexPageTopArticles();
		// 初始化所有栏目信息
		initAllSubjectNames();
		
	}

	private void initAllSubjectNames() {
		/** 遍历dataSource的所有key,
		 * key 的格式为 pathName_subjectName
		 * 
		 * 将这个key赋值给变量name
		 * 
		 * 拆分为pathName 和 subjectName
		 * 分别作为 key, value
		 * 存入一个Map中
		 * 然后,把Map存入中
		 */
		Set<String> subjects = dataSource.keySet();
		for (String subject : subjects) {
			String pathName = subject.split("_")[0];
			String subjectName = subject.split("_")[1];
			Map<String, String> aSubject = new HashMap<>();
			aSubject.put("pathName", pathName);
			aSubject.put("subjectName", subjectName);
			allSubjectNames.add(aSubject);
		}
		System.err.println(allSubjectNames);
	}

	private void initIndexPageTopArticles() {
		indexPageTopArticles = topArticles.
		subList(0, Integer.min(5, topArticles.size()));
	}

	private void initTop15Articles() {

		/**
		 * 1. 将所有栏目中的所有文章存入一个文章集合
		 */
		Collection<List<Article>> values = dataSource.values();
		/**
		 * 2. 将得到的文章集合按照最后修改时间排序
		 */
		for (List<Article> e :values) {
			topArticles.addAll(e);
		}
		// 排序
		topArticles.sort(
				(a1, a2) -> a1.getLastModified() > a1.getLastModified() ? -1 : 1);
		
		/**
		 * 3. 取15条
		 */
		topArticles = topArticles.subList(0, Integer.min(topArticles.size(), 15));

	}

	public Map<String, List<Article>> getDataSource() {
		return dataSource;
	}

	public void setDataSource(Map<String, List<Article>> dataSource) {
		this.dataSource = dataSource;
	}

	public List<Article> getTopArticles() {
		return topArticles;
	}

	public void setTopArticles(List<Article> topArticles) {
		this.topArticles = topArticles;
	}

	public List<Article> getIndexPageTopArticles() {
		return indexPageTopArticles;
	}

	public void setIndexPageTopArticles(List<Article> indexPageTopArticles) {
		this.indexPageTopArticles = indexPageTopArticles;
	}

	public List<Map<String, String>> getAllSubjectNames() {
		return allSubjectNames;
	}

	public void setAllSubjectNames(List<Map<String, String>> allSubjectNames) {
		this.allSubjectNames = allSubjectNames;
	}
	
	
	
	
	
}
