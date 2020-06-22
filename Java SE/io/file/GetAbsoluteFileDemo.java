package io.file;

import java.io.File;

public class GetAbsoluteFileDemo {
	public static void main(String[] args) {
		File file = new File("./file/NewFileDemo.java");
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);
		
	}
}
