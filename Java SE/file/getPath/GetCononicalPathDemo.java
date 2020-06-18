package file.getPath;

import java.io.File;
import java.io.IOException;

public class GetCononicalPathDemo {
	public static void main(String[] args) {
		File file = new File("./file.NewFileDemo.java");
		try {
			String cononicalPath = file.getCanonicalPath();
			System.out.println(cononicalPath);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
