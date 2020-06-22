package io.file;

import java.io.File;

public class GetNameDemo {
	public static void main(String[] args) {
		File file = new File("./file/NewFileDemo.java");
		String name = file.getName();
		System.out.println(name);
	}
}
