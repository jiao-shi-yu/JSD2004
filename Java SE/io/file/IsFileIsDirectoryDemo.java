package io.file;

import java.io.File;

public class IsFileIsDirectoryDemo {
	public static void main(String[] args) {
		File file = new File("./file/NewFileDemo.java");
		boolean isFile = file.isFile();
		System.out.println("file.isFile(): " + isFile);
		boolean isDirectory = file.isDirectory();
		System.out.println("file.isDirectory: " + isDirectory);
	}
}
