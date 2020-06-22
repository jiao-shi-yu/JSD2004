package io.file;

import java.io.File;

public class MkDirDemo {
	public static void main(String[] args) {
		File dir = new File("./example");
		boolean success = dir.mkdir();
		System.out.println("成功创建:" + success);
		
	}
}
