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
	 * Getters and Setters
	 */
	
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

	
	
	/**
	 * 将.md解析为.html的解析器, 没啥卵用，直接复制粘贴
	 */
	private static MutableDataSet options = new MutableDataSet();
	private static Parser parser = Parser.builder(options).build();
	private static HtmlRenderer renderer = HtmlRenderer.builder(options).build();
	
	/**
	 * 通过一个file文件来生成一个Article对象
	 * @param file
	 */
	public Article(File file) {
		// 初始化文件相关信息
		initFileInfo(file);
		// 初始化内容相关信息
		initFileContent(file);
	}



	private void initFileInfo(File file) {
		fileName = file.getName().replace(".md", "html");
		lastModified = file.lastModified();
		String pathDashSubject = file.getParentFile().getName();
		String[] pathCommaSubject = pathDashSubject.split("_");
		pathName = pathCommaSubject[0];
		subjectName = pathCommaSubject[1];
		System.err.println("文件信息已生成");
	}
	
	private void initFileContent(File file) {
		// 读取.md文件中的内容，并用一个String保存
		try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
			byte[] data = new byte[(int)raf.length()];
			raf.read(data);
			String txt = new String(data, "utf-8");
			
			// 上部分是元数据，包含了标题、作者、日期
			// 先对元数据进行截取
			// 开始位置 和 结束位置
			int start = txt.indexOf("---") + 3;
			int end = txt.indexOf("---", start);
			System.err.println(start + " " + end);
			// 开始截取
			String metaStr = txt.substring(start, end);
			// 对元数据部分，逐行读取，并解析为 key 和 value，存入Map中
			
			/**
			 * Scanner可以使用字符串作为参数构建！并且按行读取
			 */
			Scanner scanner = new Scanner(metaStr);
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				if (line.trim().isEmpty()) {
					continue;
				}
				String[] arr = line.split(":\\s");
				metaData.put(arr[0], arr[1]);
			}
			scanner.close();
			
			// 下部分是正文
			
			String contentStr = txt.substring(end + 3);
			
			System.err.println("正文已经生成");
			
			Node doc = parser.parse(contentStr);
			content = renderer.render(doc);
			System.out.println(content);
			System.err.println("解析得到的content: \n" + content);
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}	
	
	
	
}
