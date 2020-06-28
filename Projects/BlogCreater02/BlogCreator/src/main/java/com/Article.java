package com;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Article��ʾһƪ����
 * @author jiao_
 *
 */
public class Article {
	// �ļ��� ��.md�ļ�ת��Ϊ.html
	private String fileName;
	// ·����
	private String pathName;
	// ��Ŀ��
	private String subjectName;
	// ����޸�ʱ��
	private long lastModified;
	
	// Ԫ����
	private Map<String, String> metaData = new HashMap<>();
	// ����
	private String content;
	
	/**
	 * ͨ��һ��file�ļ�������һ��Article����
	 * @param file
	 */
	public Article(File file) {
		// ��ʼ���ļ������Ϣ
		initFileInfo(file);
		// ��ʼ�����������Ϣ
		
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
