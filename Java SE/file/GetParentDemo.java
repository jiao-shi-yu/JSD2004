package file;

import java.io.File;

public class GetParentDemo {
	public static void main(String[] args) {
		File file = new File("./file/NewFileDemo.java");
		String parent = file.getParent();
		System.out.println(parent);
		
	}
}
