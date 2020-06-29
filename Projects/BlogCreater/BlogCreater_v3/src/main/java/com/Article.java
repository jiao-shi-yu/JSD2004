package com;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

/**
 * Article一篇文章
 * @author jiao_
 *
 */
public class Article {
	// markdown转换为html的解析器
	private static MutableDataSet options = new MutableDataSet();
	private static Parser parser = Parser.builder(options).build();
	private static HtmlRenderer renderer = HtmlRenderer.builder(options).build();
	// 文件名， 将来用于超链接可以定位该文章
	private String fileName;
	/* 例如it_科技 it解析为url中的path的一部分 科技解析为栏目名。*/
	// 目录名it
	private String pathName;
	// 栏目名
	private String subjectName;
	// 最后修改时间
	private long lastModified; // 基于文件最后修改时间
	
	// 元数据
	private Map<String, String> metaData = new HashMap<>();
	
	// 正文
	private String content;
	
	// 构造方法
	public Article(File file) {
		// 文件相关信息
		initFileInfo(file);
		// 内容相关信息
		initContent(file);
	}
	private void initFileInfo(File file) {
		System.err.println("开始初始化文件信息");
		fileName = file.getName().replace(".md", ".html");
		lastModified = file.lastModified();
		String pathAndSubject = file.getParentFile().getName();
		String[] pathCommaSubject = pathAndSubject.split("_");
		pathName = pathCommaSubject[0];
		subjectName = pathCommaSubject[1];
		
		System.out.println("fileName: " + fileName);
		System.out.println("pathName: " + pathName);
		System.out.println("subjectName: " + subjectName);
		
		System.out.println("lastModified: " + lastModified);
		
		System.err.println("完成初始化文件信息");
	}
	private void initContent(File file) {
		/**
		 * 先读取md文件中的所有内容
		 * 并用一个String保存
		 * 
		 * 然后读上部分
		 * 
		 * 然后读下部分
		 */
		try (RandomAccessFile raf = new RandomAccessFile(file, "r");) {
			byte[] data = new byte[(int)raf.length()];
			raf.read(data);
			String txt = new String(data, "utf-8");
			System.out.println(txt);
			
			// 截取出元数据部分
			int start = txt.indexOf("---") + 3;
			int end = txt.indexOf("---", start);
			String metaStr = txt.substring(start, end);
			System.out.println(metaStr);
			// Scanner 可以读取字符串
			Scanner scanner = new Scanner(metaStr);
			// 读取一行元数据
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.trim().isEmpty()) {
					continue;
				}
				String[] arr = line.trim().split(":\\s");
				metaData.put(arr[0], arr[1]);
			}
			scanner.close();
			System.err.println("\n\t" + "metaData: " + metaData);
			
			
			// 截取出文章内容
			String contentStr = txt.substring(end + 3);
			System.out.println(contentStr);
			
			Node doc = parser.parse(contentStr);
			content = renderer.render(doc);
			System.err.println("来了老弟");
			System.out.println(content);
		} catch (Exception e) {
			e.equals(e);
		}
		
		
		
		
		
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getPathName() {
		return pathName;
	}
	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public long getLastModified() {
		return lastModified;
	}
	public void setLastModified(long lastModified) {
		this.lastModified = lastModified;
	}
	public Map<String, String> getMetaData() {
		return metaData;
	}
	public void setMetaData(Map<String, String> metaData) {
		this.metaData = metaData;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
