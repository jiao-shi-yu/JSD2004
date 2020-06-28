package com;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Article表示一篇文章
 * @author jiao_
 *
 */
public class Article {
	// 文件名 将.md文件转换为.html
	private String fileName;
	// 路径名
	private String pathName;
	// 栏目名
	private String subjectName;
	// 最后修改时间
	private long lastModified;
	
	// 元数据
	private Map<String, String> metaData = new HashMap<>();
	// 正文
	private String content;
	
	/**
	 * 通过一个file文件来生成一个Article对象
	 * @param file
	 */
	public Article(File file) {
		// 初始化文件相关信息
		initFileInfo(file);
		// 初始化内容相关信息
		
	}

	private void initFileInfo(File file) {
		fileName = file.getName().replace(".md", "html");
		lastModified = file.lastModified();
		String pathDashSubject = file.getParentFile().getName();
		String[] pathCommaSubject = pathDashSubject.split("_");
		pathName = pathCommaSubject[0];
		subjectName = pathCommaSubject[1];
		
		
	}
	
	
	
	
	
	
	
}
