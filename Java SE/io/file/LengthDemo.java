package io.file;

import java.io.File;

public class LengthDemo {
	public static void main(String[] args) {
		File file = new File("./file/NewFileDemo.java");
		long length = file.length();
		System.out.println(length);
	}
}
