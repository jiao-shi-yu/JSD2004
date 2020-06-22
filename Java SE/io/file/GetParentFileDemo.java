package io.file;

import java.io.File;

public class GetParentFileDemo {
	public static void main(String[] args) {
		File file = new File("./file/NewFileDemo.java");
		File parentFile = file.getParentFile();
		System.out.println(parentFile.getAbsolutePath());
		
	}
}
