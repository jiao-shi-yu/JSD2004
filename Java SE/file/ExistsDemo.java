package file;

import java.io.File;

public class ExistsDemo {
	public static void main(String[] args) {
		File file = new File("./demo");
		boolean exists = file.exists();
		System.out.println(exists);
	}
}
