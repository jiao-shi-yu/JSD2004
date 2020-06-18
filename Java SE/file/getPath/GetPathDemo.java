package file.getPath;

import java.io.File;

public class GetPathDemo {
	public static void main(String[] args) {
		File file = new File("./file/NewFileDemo.java");
		String path = file.getPath();
		System.out.println(path);
	}
}
