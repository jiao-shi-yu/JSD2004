package com;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		
	}
	
	


	private void initPrevie5Articles() {
		
	}

	private void initSubjectNames() {
		
	}

}
