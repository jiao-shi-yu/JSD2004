package file.getPath;

import java.io.File;

public class GetAbsolutePathDemo {
	public static void main(String[] args) {
		File file = new File("./file/NewFileDemo.java");
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);
	
	}
}
